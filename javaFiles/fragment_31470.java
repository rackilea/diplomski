static InputStream is = null;
DefaultHttpClient httpClient = new DefaultHttpClient();
if (params != null && params.size() > 0){
    String paramString = URLEncodedUtils.format(params, "utf-8");
    url += "?" + paramString;
}
HttpGet httpGet = new HttpGet(url);
HttpResponse httpResponse = httpClient.execute(httpGet);
HttpEntity httpEntity = httpResponse.getEntity();
is = httpEntity.getContent();