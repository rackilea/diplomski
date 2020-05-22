public void sendHttpPost() throws ClientProtocolException, IOException {
    HttpMethodBase httpPostRequest = new PostMethod(url + buildParams());


    try {
        // add headers
        Iterator it = headers.entrySet().iterator();
        while (it.hasNext()) {
            Entry header = (Entry) it.next();
            httpPostRequest.addRequestHeader((String) header.getKey(), (String) header.getValue());

        }
       ((PostMethod) httpPostRequest).setRequestEntity( new StringRequestEntity(new                                                    
    String(reqEntity), "text/plain", Constants.DEFAULT_ENCODING));
    try {
            respCode = client.executeMethod(httpPostRequest);
            response = httpPostRequest.getResponseBodyAsString();
            this.responsePhrase = httpPostRequest.getStatusText();

    }catch(Exception ex){
      System.out.println("ErrorS "+ex.toString());
        } finally {
            httpPostRequest.releaseConnection();
        }
    }catch(Exception ex){
      System.out.println("ErrorD "+ex.toString());
    }
        finally {

    }
}