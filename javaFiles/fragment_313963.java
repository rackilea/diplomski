String url = "http://localhost/SpringTilesWebApp/welcome.htm";

HttpClient client = new DefaultHttpClient();
HttpPost post = new HttpPost(url);

List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
urlParameters.add(new BasicNameValuePair("requestObj", requestObj));    

post.setEntity(new UrlEncodedFormEntity(urlParameters));

HttpResponse response = client.execute(post);

    //read and process response