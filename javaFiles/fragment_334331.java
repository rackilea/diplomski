private class LongOperation extends AsyncTask<String, Void, String> {

      @Override
      protected void onPreExecute() {
          // Start progressbar
      }

      @Override
      protected String doInBackground(String... params) {
          // Computing goes here
          return null;
     }

     @Override
     protected void onPostExecute(String result) {
         // Stop progressbar
         UpdateMyGUI();
     }

     @Override
     protected void onProgressUpdate(Void... values) {
         // Update progressbar (?)
     }
}

private void updateMyGUI(){
    runOnUiThread (new Runnable() {  
        public void run() {
            // Update GUI Here.
        }
    });
}