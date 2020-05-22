HttpClient client = new DefaultHttpClient();
HttpParams params = client.getParams();
HttpClientParams.setRedirecting(params, false);
HttpGet method = new HttpGet("http://forecast.weather.gov/zipcity.php?inputstring=90210");
HttpResponse resp = client.execute(method);
String location = resp.getLastHeader("Location").getValue();