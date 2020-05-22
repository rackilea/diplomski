// setup the client
HttpContext httpContext = new BasicHttpContext();
DefaultHttpClient httpClient = new DefaultHttpClient();

// setup the request
HttpPost post = new HttpPost("http://someurl.com/");
List<BasicNameValuePair> pairs = new ArrayList<BasicNameValuePair>();
pairs.add(new BasicNameValuePair("name" , "value"));
post.setEntity(new UrlEncodedFormEntity(pairs));

// execute the request
BasicHttpResponse response =
        (BasicHttpResponse)httpClient.execute(post, httpContext);

// do something with the response
InputStream is = response.getEntity().getContent();
BufferedReader br = new BufferedReader(new InputStreamReader(is));

String content;
StringBuilder contentBuilder = new StringBuilder();

String line = null;
while((line = br.readLine()) != null)
    contentBuilder.append(line);

br.close();
is.close();

content = contentBuilder.toString();

// done!