public class NewAsyncTask extends AsyncTask<Void, Void, String>
 {
  private ProgressDialog mDialog;

  Context mCntxt;

  public NewAsyncTask(Context context) 
     {
    mCntxt = context;
     }

@Override
protected void onPreExecute() 
{
    new ProgressDialog(mCntxt);
    mDialog = ProgressDialog.show(mCntxt, "", "Loading..");
    super.onPreExecute();
}

@Override
protected String doInBackground(Void... params) 
{
  //code for writing excel sheet
   return "success";

}

@Override
protected void onPostExecute(String result) 
{
    if(mDialog!=null && mDialog.isShowing())
    {
        mDialog.dismiss();
    }
    if (result.length()>0) 
    {
        new AlertDialog.Builder(mCntxt)
    .setTitle("")
    .setMessage("")
    .setIcon(R.drawable.ic_launcher)
    .setCancelable(false)
    .setPositiveButton("OK"),
    new DialogInterface.OnClickListener()
    {
        public void onClick(DialogInterface dialog, int whichButton)
        {
            dialog.dismiss();
        }
    })
    .create().show();
    }

    super.onPostExecute(result);
}



 }