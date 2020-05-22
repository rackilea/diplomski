private class LongOperation extends AsyncTask<Void, Void, String> {

      @Override
      protected String doInBackground(String... params) {

            // Put Your Code Here Which is to be executed on button Click
            return "Executed";
      }      

      @Override
      protected void onPostExecute(String result) {
            // Dismiss Progress Dialog here
      }

      @Override
      protected void onPreExecute() {
      // Show Progress Dialog Here 

      }

}