// Creating default HttpClient
HttpClient httpClient = new DefaultHttpClient();
final HttpParams httpParams = httpClient.getParams();

// Setting timeouts
HttpConnectionParams.setConnectionTimeout(httpParams, 5000);
HttpConnectionParams.setSoTimeout(httpParams, 30000);

// Rest of your code
final HttpPost httppost = new HttpPost(address);
httppost.setHeader("Accept", "text/xml");
httppost.setHeader("Content-type", "application/xml; charset=UTF-8");
httppost.setEntity(new StringEntity(body));
final HttpResponse response = httpclient.execute(httppost);
final HttpEntity entity = response.getEntity();