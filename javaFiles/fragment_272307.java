new TheTask().execute("mystring");
   class TheTask extends AsyncTask <String,Void,Void> { 
     @Override
     protected void onPreExecute() {
       super.onPreExecute();
     }
     @Override
     protected void onPostExecute(Void result) {
      super.onPostExecute(result);
     }
     @Override
     protected Void doInBackground(String... params) {
      String value = params[0];
     return null;
     }
   }