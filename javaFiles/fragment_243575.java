private class AsyncRequestConnection extends AsyncTask<Void, Void, String> {
    private final Request request;

    public AsyncRequestConnection(Request request) {
        this.request = request;
    }

    @Override
    protected String doInBackground(Void... params) {
        try {
            HttpPost p = createRequestHttpMessage(request);
            String resp = new String(stripResponse(getRequestClient().execute(p)));
            Log.v(TAG, resp);
            return resp;
        } catch (Exception e) {
            Log.e(TAG, "Cannot complete API request", e);
            cancel(false);
            return null;
        }
    }

    @Override
    protected void onCancelled() {
        request.backoff();
        if (request.hasReachedMaxBackoff()) {
            request.cancel(R.string.error_internal);
        } else {
            requestQueue.enqueue(request);              
        }
        requestConnection = null;
        nextRequest();
    }

    @Override
    protected void onPostExecute(String result) {
        if (result != null) {
            request.attachResponse(result);
            request.handleResponse();               
            requestConnection = null;
            nextRequest();
        } else {
            request.cancel(R.string.error_internal);
        }
    }
}