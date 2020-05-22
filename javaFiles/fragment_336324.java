HttpClient httpclient = new DefaultHttpClient();

String responseXml = null;
StringEntity se = "test string to be sent to the server";


HttpPost httppost = new HttpPost(temp);
try {
    se.setContentType("text/soap+xml");
    httppost.setEntity(se);
    HttpResponse httpresponse = httpclient.execute(httppost);
    HttpEntity resEntity = httpresponse.getEntity();
    responseXml = EntityUtils.toString(resEntity);
    Log.d("Response XML", responseXml);
} catch (UnsupportedEncodingException e) {
    e.printStackTrace();
    Log.e(TAG,e.getMessage());
} catch (ClientProtocolException e) {
    Log.e(TAG,e.getMessage());
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
    Log.e(TAG, e.getMessage());
} catch (Exception e){
    e.printStackTrace();
    Log.e(TAG,e.getMessage());
}