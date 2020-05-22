RequestHandler handler = RequestHandler.getInstance();
handler.makeRequest("http://www.google.com", new RequestListener(){
    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] response) {
        // do whatever you want here.       
    }
});