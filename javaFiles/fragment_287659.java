class checking extends AsyncTask<String, Void, Boolean> {
    @Override
    protected Boolean doInBackground(String... params) {
        // TODO Auto-generated method stub
        Boolean a;
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(l1);
        HttpResponse response;
        try {
            response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                a = false;
            } else {
                a = true;
            }
            return a;
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    @Override
    protected void onPostExecute(Boolean result) {
        Toast.makeText(getApplicationContext(), (result ? "Yes" : "No"), Toast.LENGTH_LONG).show();
    }
}