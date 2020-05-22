URL url = new URL("http://example.com");
HttpURLConnection connection = (HttpURLConnection)url.openConnection();
URL urlWithInput = new URL("http://example.com" + input);
connection.setRequestMethod("GET");   
connection.connect();       
InputStream stream = connection.getInputStream();