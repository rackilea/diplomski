HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("https://accounts.google.com/o/oauth2/token");
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("code", "<your_auth_code>"));
        pairs.add(new BasicNameValuePair("client_id", "<your_client_id>"));
        pairs.add(new BasicNameValuePair("client_secret", "<your_client_secret>"));
        pairs.add(new BasicNameValuePair("redirect_uri", "<your_redirect_uri>"));
        pairs.add(new BasicNameValuePair("grant_type", "authorization_code")); //Leave this line how it is   
        post.setEntity(new UrlEncodedFormEntity(pairs));
        org.apache.http.HttpResponse response = client.execute(post);
        String responseBody = EntityUtils.toString(response.getEntity());
        Log.v("message", responseBody); // That just logs it into logCat