// basic autthorization security 
String url = "http://nextbus.mxdata.co.uk/nextbuses/1.0/1";
String authString = "<username>:<password>";
byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
String authStringEnc = new String(authEncBytes);

DefaultHttpClient client = new DefaultHttpClient();
HttpPost post = new HttpPost(url);
post.setHeader("Authorization", "Basic " + authStringEnc);
StringEntity input = new StringEntity(request);
input.setContentType("text/xml");
post.setEntity(input);
HttpResponse response = client.execute(post);
HttpEntity entity = response.getEntity();
String unformattedXML = EntityUtils.toString(entity);