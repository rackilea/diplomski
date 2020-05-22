private class ParseTask extends AsyncTask<Params, Progress, Result> {
   @Override
   protected Result doInBackground(Params params) {
        // get url 
        Params url = params[0];
        // create HttpClient etc.
        ...
        // get response, and parse json
        // return 
        return result;
   }

   @Override
   protected void onPostExecute (Result result) {
        // now when you have result from parsed json, 
        // update application UI or whatever you need
        someEditText.setText(value_from_result);
   }
}