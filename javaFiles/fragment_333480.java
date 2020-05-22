HttpClient httpClient = initHttpClient();
    HttpPost httpPost = new HttpPost("https://login.salesforce.com/");
    MultipartEntity entity = new MultipartEntity(HttpMultipartMode.STRICT);
    entity.addPart("SAMLResponse", new StringBody(Base64.encodeBase64String(samlAssertion)));
    httpPost.setEntity(entity);
    HttpResponse httpResponse = httpClient.execute(httpPost);

    Header location = httpResponse.getFirstHeader("Location");
    if (null != location) {
        System.out.println(location.getValue());
    }