public void getData()
{
    HttpClient httpclient = new DefaultHttpClient();
    httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
    HttpGet request = new HttpGet("http://gdata.youtube.com/feeds/api/videos/XbGs_qK2PQA?v=2&alt=jsonc");

    try
    {
    HttpResponse response = httpclient.execute(request);
    HttpEntity resEntity = response.getEntity();
    String _response=EntityUtils.toString(resEntity); 

    JSONOBject json = new JSONOBject(_response);
    JSONObject data = json.getJSONObject("data");
    String tile = data.getString("title");

    }catch(Exception e)
    {
            e.printStackTrace();
     }

    httpclient.getConnectionManager().shutdown();
}