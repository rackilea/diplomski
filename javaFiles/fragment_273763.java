HttpClient client = new DefaultHttpClient();
HttpGet request = new HttpGet("http://your_website_here/file.js");
HttpResponse response = client.execute(request);
String js = EntityUtils.toString(response.getEntity());

JSContext context = new JSContext();
context.evaluateScript(js);
context.evaluateScript("question.vote(0);");