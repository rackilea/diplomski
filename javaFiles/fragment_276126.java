String url = "https://foourl.com"; 

TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;
SSLSocketFactory sf = new SSLSocketFactory(
  acceptingTrustStrategy, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
SchemeRegistry registry = new SchemeRegistry();
registry.register(new Scheme("https", 8443, sf));
ClientConnectionManager ccm = new PoolingClientConnectionManager(registry);

HttpClient client = new DefaultHttpClient(ccm);
HttpPost post = new HttpPost(url);

// set header
post.setHeader("User-Agent", "my-user-agent");
post.setHeader("Content-Type", "application/xml");

String xmlString = getXmlAsString();

List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
urlParameters.add(new BasicNameValuePair("xml", xmlString));

post.setEntity(new UrlEncodedFormEntity(urlParameters));

HttpResponse response = client.execute(post);
System.out.println("Response Code : " + 
                            response.getStatusLine().getStatusCode());

BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

StringBuffer result = new StringBuffer();
String line = "";
while ((line = rd.readLine()) != null) {
    result.append(line);
}

System.out.println(result.toString());