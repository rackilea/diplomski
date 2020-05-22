protected class ThreadA extends AsyncTask<Void, Void, JSONObject> {
    final String url = mBuilder.getURL("box");

    public ThreadA() {
    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        final RequestFuture<JSONObject> future = RequestFuture.newFuture();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, (String) null, future, future);
        requestQueue.add(request);
        try {
            return future.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }
}