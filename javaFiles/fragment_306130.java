String _respons;
 @Override
 protected String doInBackground(Void... sUrl) {
 try
    {
    HttpClient httpclient = new DefaultHttpClient();
    httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
    HttpGet request = new HttpGet("http://3pi.tf/test.xml");
    HttpResponse response = httpclient.execute(request);
    HttpEntity resEntity = response.getEntity();
    _respons=EntityUtils.toString(resEntity);
    Log.i(".........",""+_respons);
    }catch(Exception e)
    {
        e.printStackTrace();
    } 
     return _respons;

 }