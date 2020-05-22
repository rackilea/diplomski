@Override
protected void onPreExecute()
{
  super.onPreExecute();

  mProgressDialog = new ProgressDialog(MainActivity.this);
  mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
  {
    public void onCancel(DialogInterface dialog)
    {
    }
  });

  mProgressDialog.setCancelable(true);
  mProgressDialog.setMessage("Progress");
  mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
  mProgressDialog.setProgress(1);
  mProgressDialog.show();
}