HttpPost httpPost = new HttpPost(url);
    httpPost.setEntity(new InputStreamEntity(new MyInputStream(),
            4096 * 1024 * 10));
    HttpResponse response = null;

    try {
        response = httpClient.execute(httpPost);
    } catch (ClientProtocolException e) {
        e.printStackTrace();
        httpPost.abort();
    } catch (IOException e) {
        e.printStackTrace();
        httpPost.abort();
    }