HttpClient httpclient = new DefaultHttpClient();
httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
HttpPost httppost = new HttpPost(getString(R.string.url));

try {
    MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

    builder.addPart("picture", new FileBody(mSharedImagePath, ContentType.create("image/jpeg")));

    // Adding params
    List<NameValuePair> params = new ArrayList<NameValuePair>();

    params.add(new BasicNameValuePair("param1", "utf-8 encoded text");
    params.add(new BasicNameValuePair("param2", "another utf-8 encoded text");

    for (NameValuePair param : params) {
        builder.addTextBody(param.getName(), param.getValue(), ContentType.create("text/plain", Charset.forName("UTF-8")));
    }

    builder.setCharset(MIME.UTF8_CHARSET);
    httppost.setEntity(builder.build());

    HttpResponse response = httpclient.execute(httppost);

    HttpEntity resEntity = response.getEntity();
    resEntity.getContentLength();
    //......

} catch (FileNotFoundException e) {
    Logger.getInstance().log(e);
} catch (ClientProtocolException e) {
    Logger.getInstance().log(e);
} catch (IOException e) {
    Logger.getInstance().log(e);
} catch (Exception e) {
    Logger.getInstance().log(e);
}