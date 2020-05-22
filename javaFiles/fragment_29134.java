private static void testHttpClient() {
    HttpClient client = new HttpClient();
    client.setContentType("application/json; charset=utf-8");
    client.setConnectionUrl("http://www.your.url.com/");
    String content = null;
    try {
        content = client.sendHttpRequest(HttpMethod.POST);
    } catch (IOException e) {
        content = TextUtils.getStacktrace(e, false);
    }
    System.out.println(content);
}