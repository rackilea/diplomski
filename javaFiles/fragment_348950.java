HttpClient client = new DefaultHttpClient();

HttpPost method = new HttpPost("https://www.google.com/accounts/ClientLogin");
method.setHeader("Content-Type", "application/x-www-form-urlencoded");

List<BasicNameValuePair> postParams = new ArrayList<BasicNameValuePair>(4);
postParams.add(new BasicNameValuePair("accountType", "GOOGLE"));
postParams.add(new BasicNameValuePair("Email", "xxxxxxx"));
postParams.add(new BasicNameValuePair("Passwd", "xxxxxx"));
postParams.add(new BasicNameValuePair("service", "cl"));

UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(postParams);
method.setEntity(formEntity);

HttpResponse response=client.execute(method);
System.out.println(response.toString());