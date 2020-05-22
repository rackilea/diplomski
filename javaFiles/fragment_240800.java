public class DownloadFileTask extends AsyncTask{
Context mContext;

    public DownloadFileTask(Context context) {
            this.mContext = context;

        }


     @Override
      protected void onPreExecute() {



       progressDialog = new ProgressDialog(mContext);
       progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
       progressDialog.setMessage("Loading...");
       progressDialog.setCancelable(false);
       progressDialog.show();
      }
    }