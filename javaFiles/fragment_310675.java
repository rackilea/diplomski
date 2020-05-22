public class MyTask extends AsyncTask<Void, Integer, String>{

    private HttpPost httpPost;
    private CustomMultiPartEntity multipartContent;
    private HttpClient httpClient;
    @Override
    protected String doInBackground(HttpResponse... arg0) {
        httpClient = new DefaultHttpClient();
        HttpContext httpContext = new BasicHttpContext();
        httpPost = new HttpPost(urlStr);

        ....
        // other upload statement here 
        return resp;
    }
    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.e(TAG, "task cancelled");
    }

    public void taskCancel() {
        if(httpPost!=null){
            httpPost.abort();
            httpPost = null;
        }
        if(httpClient!=null){
            httpClient.getConnectionManager().shutdown();
        }
        httpClient = null;
    }
}