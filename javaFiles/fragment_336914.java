public class ApiAccess extends AsyncTask<List<NameValuePair>, Integer, String> {
...
    public IApiAccessResponse delegate=null;
    protected String doInBackground(List<NameValuePair>... nameValuePairs) {
        //do all your background manipulation and return a String response
        return response
    }

    @Override
    protected void onPostExecute(String result) {
        if(delegate!=null)
        {
            delegate.postResult(result);
        }
        else
        {
            Log.e("ApiAccess", "You have not assigned IApiAccessResponse delegate");
        }
    } 
}