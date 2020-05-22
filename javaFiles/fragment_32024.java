HttpPost httpPost = new HttpPost(url_src);
HttpParams httpParameters = new BasicHttpParams();
httpclient.setParams(httpParameters);
StringEntity se = new StringEntity(str,"UTF-8");
se.setContentType("application/json");
httpPost.setEntity(se); 



try
{
    response = httpclient.execute(httpPost);

    StatusLine statusLine = response.getStatusLine();
    int statusCode = statusLine.getStatusCode();


    if(statusCode==200)
    {
        entity = response.getEntity();
        String responseText = EntityUtils.toString(entity);
        System.out.println("The response is" + responseText);   

    }
    else
    {
        System.out.println("error");;
    }
}
catch(Exception e)
{

    e.printStackTrace();

}