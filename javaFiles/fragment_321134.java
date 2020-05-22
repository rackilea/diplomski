HttpPost post = new HttpPost("https://accounts.google.com/o/oauth2/token");
List <NameValuePair> nvps = new ArrayList <NameValuePair>();
nvps.add(new BasicNameValuePair("code", code));
nvps.add(new BasicNameValuePair("client_id", client_id));
nvps.add(new BasicNameValuePair("client_secret", client_secret));
nvps.add(new BasicNameValuePair("redirect_uri", redirect_uri));
nvps.add(new BasicNameValuePair("grant_type", grant_type));

post.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

DefaultHttpClient httpClient = new DefaultHttpClient();
HttpResponse response = httpClient.execute(post);