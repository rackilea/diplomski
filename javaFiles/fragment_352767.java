HttpClient client = new DefaultHttpClient();
HttpPut put = new HttpPut(url);
put.addHeader("Content-Type", "application/json");
put.addHeader("Accept", "application/json");
put.setEntity(new StringEntity(jsonObj.writeValue()));
HttpResponse response = client.execute(put);