String protocol = "http";
String host = "example.com";
String location = "/path/path?key1=value1&key2=value2";

String path = location.substring(0, location.indexOf("?"));
String query = location.substring(location.indexOf("?") + 1);

URI uri = new URI(protocol, host, path, query, null);