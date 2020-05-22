public class MyTask extends AsyncTask<Void,Void,Void>{

  private Context mContext; // context reference 
  private ProgressDialog pDialog;

  public MyTask(Context context){ //constructor 
   this.mContext = context;
  }

 @Override
    protected void onPreExecute() {
        pDialog = ProgressDialog.show(mContext, "Wait...", "sending data ...", true);
        pDialog.setCancelable(false);
        super.onPreExecute();
    }
}