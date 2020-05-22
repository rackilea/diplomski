public void send(){

    DefaultHttpClient httpClient = new DefaultHttpClient();

    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    nameValuePairs.add(new BasicNameValuePair("Servername", "abc"));
    nameValuePairs.add(new BasicNameValuePair("UserName", "123));
    nameValuePairs.add(new BasicNameValuePair("PassWord", "123"));
    nameValuePairs.add(new BasicNameValuePair("XML", getRequestTypeStringBuilder()));

    // Your every parameter name must be match with passing parameter, otherwise it throw 
    // an exception if it in case sensitive

    HttpPost httpPost = new HttpPost("http://app.local/DeviceLogin/");
    httpPost.addHeader("Accept", "text/xml");
    httpPost.setHeader("Content-Type","application/xml;charset=UTF-8"); 
    httpPost.setEntity(nameValuePairs);  

    HttpResponse response   = httpClient.execute(httpPost);       

    // Be aware, if your return data type is also xml, then using replace empty string,
    // otherwise, it my not retrieve or seen all data.

}

private static String getRequestTypeStringBuilder(){
     StringBuilder body = new StringBuilder("<?xml version=\"1.0 \"encoding=\"UTF-8\"?>");
    body.append("<!DOCTYPE My System\"Abc.dtd\">");
    // Please append detail your xml body in here;
    return body.toString();
}