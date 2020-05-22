String protocol = "http";
String host = "example.com";
int port = 4567;
String path = "/foldername/1234";
String auth = null;
String fragment = null;
URI uri = new URI(protocol, auth, host, port, path, query, fragment);
URL url = uri.toURL();