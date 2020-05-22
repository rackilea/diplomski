class AsyncTaskRunner extends AsyncTask<Void, Void, Void> {

  private String resp;

  @Override
  protected String doInBackground(String... params) {
//don't perform UI operation here, perform network operation
   resp = loadJSCode();
   return resp;
  }


  @Override
  protected void onPostExecute(String result) {
   // When network operation completed then this method is called and you 
  // can update UI from this method.
  }


  @Override
  protected void onPreExecute() {

  }


 }