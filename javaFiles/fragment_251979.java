private class YourAsyncTask extends AsyncTask<Void, Void, Void> {
    private ProgressDialog progDialog;

    public YourAsyncTask(MyMainActivity activity) {
        progDialog = new ProgressDialog(activity);
    }

    @Override
    protected void onPreExecute() {
       progDialog.setContentView(R.layout.progress_dialog);
       progDialog.setTitle("Calculating...");
       progDialog.setCancelable(false);
       progDialog.setCanceledOnTouchOutside(false);

       progDialog.show();
    }
    @Override
    protected Void doInBackground(Void... args) {
        // do background work here
        return null;
    }
    @Override
    protected void onPostExecute(Void result) {
         // do UI work here
        if (progDialog.isShowing()) {
            progDialog.dismiss();
        }
    }
}