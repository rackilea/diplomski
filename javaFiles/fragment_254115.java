private class PostRequestTask extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... strings) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(strings[0]);

            try {
                HttpResponse response = httpclient.execute(httppost);
                return EntityUtils.toString(response.getEntity());
            } catch (IOException e) {
                //Handle exception here
            }
        }

        protected void onPostExecute(String result) {
            TextView textView = (TextView) findViewById(R.id.idade);
            textView.setText(result);
        }
    }