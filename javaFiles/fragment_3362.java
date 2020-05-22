public class ProgressDialogs extends AsyncTask<Void,Void,Void>{

    private Context context;
    private ProgressDialog progressDialog;
    public ProgressDialogs(Context context){
        this.context=context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context, "dialog title","dialog message", true);

    }

    @Override
    protected Void doInBackground(Void... params) {
        // do you background code here
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(progressDialog!=null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }
}