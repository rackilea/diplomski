Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.0.2.100", 80));
HttpURLConnection connection =(HttpURLConnection)new URL("http://abc.example.com").openConnection(proxy);
connection.setDoOutput(true);
connection.setDoInput(true);
connection.setRequestProperty("Content-type", "text/xml");
connection.setRequestProperty("Accept", "text/xml, application/xml");
connection.setRequestMethod("POST");