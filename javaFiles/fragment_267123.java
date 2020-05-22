public static void main(String[] args) {

    String json = "{\"message\":\"This is a message\"}";

    HttpClient httpClient = new DefaultHttpClient();

    try {
        HttpPost request = new HttpPost("http://somesite.com/test.php");
        StringEntity params =new StringEntity("message=" + json);
        request.addHeader("content-type", "application/x-www-form-urlencoded");
        request.setEntity(params);
        HttpResponse response = httpClient.execute(request);

        // handle response here...

        System.out.println(org.apache.http.util.EntityUtils.toString(response.getEntity()));
        org.apache.http.util.EntityUtils.consume(response.getEntity());
    } catch (Exception ex) {
        // handle exception here
    } finally {
        httpClient.getConnectionManager().shutdown();
    }
}