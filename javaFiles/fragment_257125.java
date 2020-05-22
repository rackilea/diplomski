public void postData() throws Exception {


 HttpClient client = new DefaultHttpClient();
 HttpPost httppost = new HttpPost("https://www.xyz.com");

 List<NameValuePair> list = new ArrayList<NameValuePair>(1);

 list.add(new BasicNameValuePair("name","ABC");

 httppost.setEntity(new UrlEncodedFormEntity(list));

 HttpResponse r = client.execute(httppost);

}