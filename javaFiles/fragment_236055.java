HttpPost post = new HttpPost(URL);

    post.setHeader("Content-type", "application/json");
    post.setHeader("Authorization", "Bearer " + token));
    post.setHeader("Cache-Control", "no-cache"));

    FileBody fileBody = new FileBody(file);
    StringBody pCode = new StringBody("SOME TYPE OF VALUE", ContentType.MULTIPART_FORM_DATA);
    StringBody rType = new StringBody("SOME TYPE OF VALUE", ContentType.MULTIPART_FORM_DATA);
    //
    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
    builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
    builder.addPart("pCode", pCode);
    builder.addPart("rType", rType);
    HttpEntity entity = builder.build();
    try
    {
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
    }catch (UnsupportedEncodingException e)
    {
       e.printStackTrace();
    }

    HttpResponse response;
    try {
       response = client.execute(httpPost);
       BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
       String builder = "";

       String line = in.readLine();
       System.out.println("line = " + line);
    } catch (ClientProtocolException e)
    {
      e.printStackTrace();
    } catch (IOException e)
    {
    e.printStackTrace();
  }

}