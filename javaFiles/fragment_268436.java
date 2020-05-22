HttpContext context= new BasicHttpContext();
HttpGet get= new HttpGet(....);
client.execute(get, context);
// should contain the array of Certificate - these are more likely X509Certificate instances
Certificate[] peerCertificates= (Certificate[])context.getAttribute(PEER_CERTIFICATES);certificates
// do whatever logic to complete and consume the request