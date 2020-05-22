private void getData(){
    CloseableHttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead
    CloseableHttpResponse response = null;
    HttpEntity entity = null;

    try {
        HttpPost request = new HttpPost("url goes here");
        StringEntity params = new StringEntity("details={\"process\":\"mobileS\",\"phone\":\"9999999999\"}");
        request.addHeader("content-type", "application/x-www-form-urlencoded");
        request.setEntity(params);

        response = httpClient.execute(request);
        System.out.println(response);

        // handle response here...
        if (successful(response)) {
            entity = response.getEntity();
            String content = EntityUtils.toString(entity);

            System.out.println(content);
        }
    } catch (Exception ex) {
        // handle exception here
    } finally {
        EntityUtils.consumeQuietly(entity);
        if (response != null) response.close();
        if (httpClient != null) httpClient.close();
    }
}

// TODO Customize for your server/interaction
private boolean successful(HttpResponse response) {
    return response != null 
            && response.getStatusLine() != null 
            && response.getStatusLine().getStatusCode() == 200;
}