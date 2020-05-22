HttpPost httpost = new HttpPost(LOGIN_URL);
    List <NameValuePair> nvps = new ArrayList <NameValuePair>();
    nvps.add(new BasicNameValuePair("test1","test1" ));
    nvps.add(new BasicNameValuePair("test2", "test2" ));

            httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

    response = getResponse(httpost);