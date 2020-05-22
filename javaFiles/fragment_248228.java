public String getURL(String url) {

    System.out.println("Fetching " + url);

    if (this.httpClient == null) {
        this.initializeHTTPSession();
    }

    ResponseHandler<String> responseHandler = new BasicResponseHandler();
    HttpGet get = new HttpGet(url);

    String result = null;

    try {
        result = this.httpClient.execute(get, responseHandler);
    } catch (HttpResponseException e) {
        System.out.println(e.getMessage());
        return null;
    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (UnknownHostException e) {
        result = "The host is invalid: " + url;
    } catch (IOException e) {
        e.printStackTrace();
    }

    return result;
}