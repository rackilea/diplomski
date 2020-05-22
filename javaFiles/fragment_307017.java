ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
    @Override
    public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
        return EntityUtils.toString(response.getEntity());
    }
    };