public String putDataToServer(String url,JSONObject returnedJObject) throws Throwable
{
    HttpPost request = new HttpPost(url);
    JSONStringer json = new JSONStringer();
    StringBuilder sb=new StringBuilder();


    if (returnedJObject!=null) 
    {
        Iterator<String> itKeys = returnedJObject.keys();
        if(itKeys.hasNext())
            json.object();
        while (itKeys.hasNext()) 
        {
            String k=itKeys.next();
            json.key(k).value(returnedJObject.get(k));
            Log.e("keys "+k,"value "+returnedJObject.get(k).toString());
        }             
    }
    json.endObject();


    StringEntity entity = new StringEntity(json.toString());
                         entity.setContentType("application/json;charset=UTF-8");
    entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));
    request.setHeader("Accept", "application/json");
    request.setEntity(entity); 

    HttpResponse response =null;
    DefaultHttpClient httpClient = new DefaultHttpClient();

    HttpConnectionParams.setSoTimeout(httpClient.getParams(), Constants.ANDROID_CONNECTION_TIMEOUT*1000); 
    HttpConnectionParams.setConnectionTimeout(httpClient.getParams(),Constants.ANDROID_CONNECTION_TIMEOUT*1000); 
    try{
        response = httpClient.execute(request); 
    }
    catch(SocketException se)
    {
        Log.e("SocketException", se+"");
        throw se;
    }
    InputStream in = response.getEntity().getContent();
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    String line = null;
    while((line = reader.readLine()) != null){
        sb.append(line);
    }
    return sb.toString();
}