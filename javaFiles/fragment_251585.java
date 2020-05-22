HttpParams my_httpParams = new BasicHttpParams();
HttpConnectionParams.setConnectionTimeout(my_httpParams, 3000);
HttpConnectionParams.setSoTimeout(my_httpParams, 1);
DefaultHttpClient defaultHttpClient = new DefaultHttpClient(my_httpParams);
HttpGet httpGet = new HttpGet("http://google.com");
defaultHttpClient.execute(httpGet);