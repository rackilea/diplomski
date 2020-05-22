public void commandModule(String url) {
        new RequestTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,url);

}


private class RequestTask extends AsyncTask<String,Void,Void>{
    protected void doInBackground(String... args){

        String url=args[0];
        try {
            HttpClient httpClient = new DefaultHttpClient();
            httpClient.execute(new HttpGet(url));
        } catch (Exception e) {

        }

    }
}