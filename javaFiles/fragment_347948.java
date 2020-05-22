List<NameValuePair> parameters = new ArrayList<NameValuePair>();
parameters.add(new BasicNameValuePair("username", "test"));
parameters.add(new BasicNameValuePair("password", "test"));

UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters);
httpPost.setEntity(entity);
httpPost.addHeader("content-type", "application/json");
HttpResponse httpResponse = httpClient.execute(httpPost);