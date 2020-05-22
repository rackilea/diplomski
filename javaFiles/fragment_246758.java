public class MyClientTask extends AsyncTask<Void, Void, String> {

   ...

   @Override
   protected String doInBackground(Void... arg0) {
      ...
      return response;
   }

   @Override
   protected void onPostExecute(String result) {
      super.onPostExecute(result);
      textResponse.setText(result);
   }
}