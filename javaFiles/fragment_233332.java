Protocol easyhttps = new Protocol("https", (ProtocolSocketFactory)new EasySSLProtocolSocketFactory(), 443);
Protocol.registerProtocol("https", easyhttps);

HttpClient client = new HttpClient();
GetMethod httpget = new GetMethod("https://localhost/");
client.executeMethod(httpget);