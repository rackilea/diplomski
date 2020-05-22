if (method == "POST") {
    HttpPost httpPost = new HttpPost(url);
    if (params != null)
        httpPost.setEntity(new UrlEncodedFormEntity(params));
     // else - just nothing

    HttpResponse httpResponse = httpClient.execute(httpPost);
    HttpEntity httpEntity = httpResponse.getEntity();

    inputStream = httpEntity.getContent();
}