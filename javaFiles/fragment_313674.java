YouClass
{
ProgressDialog dialog;

 onCreate(....)
{
  //Execute the async task here.
  new myNetworkingTask().execute("");
}

private class myNetworkingTask extends AsyncTask<String, Void, String> {

  @Override
  protected String doInBackground(String... params) 
        {
            //In this method you will do the networking task
            httpclient.execute();
        }
        return "";
  }      

  @Override
  protected void onPostExecute(String result) { 
          //In this method you will hide the progress bar
         dialog.dismiss();
  }

  @Override
  protected void onPreExecute() {
         //In this method you will display the progress bar.
        dialog = ProgressDialog.show(MyActivity.this, "", 
                    "Loading. Please wait...", true); 
  }

  @Override
  protected void onProgressUpdate(Void... values) {
  }