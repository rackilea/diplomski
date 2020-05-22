private class MyAsyncTask extends AsyncTask<Void, Void, Void> {

    private ProgressDialog progressDialog;
    private Context context;

    public MyAsyncTask(Context context) {

        this.context = context;
    }

    @Override
    protected void onPreExecute() {

        super.onPreExecute();
        progressDialog = ProgressDialog.show( context, null, "Fetching routes data ..." );
    }

    @Override
    protected Void doInBackground( Void... params ) {

        while (!task_complete) {
            refresh_routes();
            try {
                Thread.sleep( 1000 );
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute( Void result ) {

        super.onPostExecute( result );
        progressDialog.dismiss();
    }
}