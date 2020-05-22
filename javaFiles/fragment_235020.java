EditText host   = (EditText)findViewById(R.id.editText);
    EditText port   = (EditText)findViewById(R.id.editText2);
    EditText community   = (EditText)findViewById(R.id.editText3);

    String url = "http://192.168.0.102/za/getstatus.php?host=" + host.getText().toString() + "&port=" + port.getText().toString() + "&com=" + community.getText().toString() + "&oid=" + 2 + "&port1=" + 2;

    new Task(url).execute();

    }

    class Task extends AsyncTask<Void, Void, HttpResponse>{
        private String url;

        Task(String url) {
            this.url = url;
        }

        @Override
        protected HttpResponse doInBackground(Void... voids) {
            HttpClient httpclient = new DefaultHttpClient();

            // Prepare a request object
            HttpPost httpPost = new HttpPost(url);

            try {
                return httpclient.execute(httpPost);

            } catch (ClientProtocolException e) {
                // writing exception to log
                e.printStackTrace();
            } catch (IOException e) {
                // writing exception to log
                e.printStackTrace();
            return null;
        }

        @Override
        protected void onPostExecute(HttpResponse httpResponse) {
            super.onPostExecute(httpResponse);
            if(httpResponse != null){
                Log.d("Http Response:", response.toString());
            }
        }
    }