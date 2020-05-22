private class Execute extends AsyncTask<Void, Void, Void> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... arg0) {
        HttpHandler httpHandler = new HttpHandler();

        String jsonString = httpHandler.makeServiceCall(jsonUrl);

        if (jsonString != null) {

            try {
                //Parse JSON
            } catch (JSONException e) {
                Log.i("Error: ", e.getMessage());
            }

        }

        return null;
    }

    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }
}