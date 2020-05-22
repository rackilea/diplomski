public HttpResponse postData(String strXML) {
    // Create a new HttpClient and Post Header
    HttpClient httpclient = new DefaultHttpClient();
    HttpPost httppost = new HttpPost("web service URL");

    try {
        StringEntity strEntity = new StringEntity(strXML,HTTP.UTF_8);
        strEntity.setContentType("text/xml");  
        httppost.setHeader("Content-Type","application/soap+xml;charset=UTF-8");
        httppost.setEntity(strEntity);  // here you can set request value.

        // Execute HTTP Post Request
        HttpResponse response = httpclient.execute(httppost);
        return response;
    } catch (ClientProtocolException e) {
        // TODO Auto-generated catch block
    } catch (IOException e) {
        // TODO Auto-generated catch block
    }

    return null;
}