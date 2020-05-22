HttpClient httpclient;
    HttpPost httppost;
    ArrayList<NameValuePair> postParameters;
    httpclient = new DefaultHttpClient();
    httppost = new HttpPost("your login link");


    postParameters = new ArrayList<NameValuePair>();
    postParameters.add(new BasicNameValuePair("param1", "param1_value"));
    postParameters.add(new BasicNameValuePair("param2", "param2_value"));

    httpPost.setEntity(new UrlEncodedFormEntity(postParameters, "UTF-8"));

    HttpResponse response = httpclient.execute(httpPost);