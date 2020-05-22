public class MyAsyncTask extends AsyncTask<String, Void, String>
{
    @Override
    protected String doInBackground(String... requestUrl) 
    {
        String result = null;

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet request = new HttpGet(requestUrl[0]);

        try
        {
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            result = httpClient.execute(request, responseHandler);
        }
        catch (IOException e)
        {
            Log.e("requestStringFromWebServer", "Whoops!", e);
        }

        httpClient.getConnectionManager().shutdown();

        return result;
    }

    @Override
    protected void onPostExecute(String result)
    {
        if (result != null)
        {
            // Handle the result from your request here...
        }
    }
}