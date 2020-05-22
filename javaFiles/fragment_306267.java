DefaultHttpClient httpclient = new DefaultHttpClient();
HttpContext localContext = new BasicHttpContext();
HttpGet httpget = new HttpGet("http://www.google.com/");
HttpResponse response = httpclient.execute(httpget, localContext);
HttpHost target = (HttpHost) localContext.getAttribute(
 ExecutionContext.HTTP_TARGET_HOST);// this is the final page of the request
System.out.println("Final target: " + target);
HttpEntity entity = response.getEntity();
EntityUtils.consume(entity);