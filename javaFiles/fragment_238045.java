... AsyncTask<String, String, String>() {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // show dialog
        }
    // UPDATE
    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
       // this method will be called when you call
      //  publishProgress from doInBackground.
    }       
        @Override
        protected String doInBackground(String[] params) {
            // load data and return
           // this data will passed to onPostExecute
            publishProgress(param); // call onProgressUpdate
            return null;
        }

        @Override
        protected void onPostExecute(String o) {
            super.onPostExecute(o);
            // hide dialog
        }
}