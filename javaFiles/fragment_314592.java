HttpClient httpClient = AndroidHttpClient.newInstance("App");
    HttpPost httpPost = new HttpPost("http://your-server-url");

    httpPost.setEntity(new FileEntity(new File("your-file-path"), "application/octet-stream"));

    HttpResponse response = httpClient.execute(httpPost);