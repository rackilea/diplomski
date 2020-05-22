DefaultHttpClient httpClient = new DefaultHttpClient();
HttpGet get = new HttpGet(url);

try {
    HttpResponse httpResponse = httpClient.execute(get);
    String json = EntityUtils.toString(httpResponse.getEntity());
    System.out.println(json);
    ....
    ....

} catch (Exception e) {
    ....
}