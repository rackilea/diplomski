String url = "http://example.com" + "/" + input
HttpURLConnection connection = (HttpURLConnection)url.openConnection();
URL urlWithInput = new URL(url);
connection.setRequestMethod("GET");   
connection.connect();       
InputStream stream = connection.getInputStream();