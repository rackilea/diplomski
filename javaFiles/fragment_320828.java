DefaultHttpClient httpClient = new DefaultHttpClient();
    HttpPost httpPost = new HttpPost(blobUploadURL);
    String param="param";
    httpPost.setParameter("parameter, param);
    try {
        HttpResponse response = httpClient.execute(httpPost);
        statusCode = response.getStatusLine().getStatusCode();
    }