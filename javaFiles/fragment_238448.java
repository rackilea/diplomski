class LoginTask extends AsyncTask<String, Void, RSSFeed> {

    private Exception exception;

    protected YourResponse doInBackground(String... urls) {
        try {
             URL url = new URL(urls[0]);
            //your login code
        } catch (Exception e) {
            this.exception = e;
        } 
    }
    protected void onPostExecute(YourResponse response) {
        // TODO: check this.exception
        // TODO: do something with the feed
    }
}