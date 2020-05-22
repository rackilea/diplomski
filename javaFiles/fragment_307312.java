AsyncHttpClient client = new AsyncHttpClient();
client.get("http://www.dfsdfsdfsdfsd.com", new AsyncHttpResponseHandler() {
    @Override
    public void onSuccess(String response) {
      // Here is your content !
    }
});