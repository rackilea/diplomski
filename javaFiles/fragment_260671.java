public class MyVolleyAsyncTask extends AsyncTask<String,String, JSONObject> {

    private Context ctx;

    public MyVolleyAsyncTask(Context hostContext)
    {
        ctx = hostContext;
    }

    @Override
    protected JSONObject doInBackground(String... params) {

        // Method runs on a separate thread, make all the network calls you need
        TestVolley tester = new TestVolley();

        return tester.fetchModules(ctx);
    }


    @Override
    protected void onPostExecute(JSONObject result)
    {
       // runs on the UI thread
       // do something with the result
    }
}