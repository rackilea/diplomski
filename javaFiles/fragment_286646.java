new ProgAsyncTask().execute();

private class ProgAsyncTask extends AsyncTask<Void, Void, String> {

    private static final String TAG = "ProgAsyncTask"; // Tag used in log msgs
    @Override
    protected String doInBackground(Void... params) {
        Log.d(TAG, "come to run");
        con = db.getHmsConnection();
        String query = "select name,Phone,message from contactdetails where Phone='" + incomingNumber1 + "'";
        resVec = ut.multipleElemInSingleVector(query, con);
        Log.d(TAG, "the vector values "+resVec);
        msg = resVec.get(2).toString();
        Log.d(TAG, "message :" + msg);
        return msg;
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, "Incoming number :" + msg, Toast.LENGTH_LONG).show();
    }
}