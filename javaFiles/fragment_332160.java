private class MyAsyncTask extends AsyncTask<String, Void, String> {

      @Override
      protected String doInBackground(String... params) {
            .... // runs on background / non-UI thread
      }      

      @Override
      protected void onPostExecute(String result) {   
            ... // runs on UI thread            
      }

      @Override
      protected void onPreExecute() {
            ... // runs on UI thread      
      }

      @Override
      protected void onProgressUpdate(Void... values) {
      }
}