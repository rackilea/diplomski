pd= new ProgressDialog(this);
    pd.setTitle("Making Soap Request");
     new SoapRequestTask().execute();

 private class SoapRequestTask extends AsyncTask<VOid, Void, Void> {

  protected void onPreExecute()
  {
      pd.show();
  }
   protected SoapObject doInBackground(Void... params) {
    // TODO Auto-generated method stub
           //Soap request. do not update ui here
    return null;
    }

 protected void onPostExecute(Void param)
 {   
      //update ui here
  pd.dismiss();

 }