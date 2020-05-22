private class LoadDataTask extends AsyncTask<Void, Void, Void> {
    @Override
    protected void onPreExecute() {
        pDialog.setMessage("Loading Data.. Please Wait.");
        pDialog.show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        doVeryMuchWork();
    }

    @Override
    protected void onPostExecute() {
        pDialog.dismiss();
    }
}