//this should be inside your Activity class
private class NetworkRequestTask extends AsyncTask<Void, Void, String>{

    @Override
    protected String doInBackground(Void... params) {
        // your network code here
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        // set the result to your label
    }

}