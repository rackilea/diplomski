String proxyHost = "proxy.xyz.co.in"; //replace with your proxy server name or IP
int proxyPort = 8080; //your proxy server port
SocketAddress addr = new InetSocketAddress(proxyHost, proxyPort);
Proxy httpProxy = new Proxy(Proxy.Type.HTTP, addr);

URLConnection urlConn = null;
BufferedReader reader = null;
String response = "";
String output = "";
URL url = new URL("www.google.com");
//Pass the Proxy instance defined above, to the openConnection() method
urlConn = url.openConnection(httpProxy); 
urlConn.connect();
reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
response = reader.readLine();
while (response!=null) {
    output+= response;
    response = reader.readLine();
}   
System.out.println("Output: " + output);