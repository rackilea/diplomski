private class AsyncTaskSample extends AsyncTask<Void, Void, Void> {
  @Override
  protected Void doInBackground(Void) {
      LlamadoServicio("david");
  }


  @Override
  protected void onPostExecute(Void) {
       progress.dismiss();
  }


  @Override
  protected void onPreExecute() {
   // Things to be done before execution of long running operation. For
   // example showing ProgessDialog
      progress = ProgressDialog.show(Menu.this, null, null, true);
      progress.setContentView(R.layout.elemento_progress_dialog);
      progress.show();
  }

 }