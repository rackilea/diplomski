public class CheckUsername extends AsyncTask<String[], Void, String> {
    @Override
    protected String doInBackground(String[]... params) {
        //... do your stuff
        return statusValue;
    }

    @Override
    protected void onPostExecute(String statusValue) {
        setText(statusValue);
    }
}