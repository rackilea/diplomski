URL url = new URL ("http://someurl.doesnotexist.com");
   URLConnection connection = url.openConnection();
   connection.connect();
   HttpURLConnection httpConnection = (HttpURLConnection) connection; 
   int code = httpConnection.getResponseCode();
   //do something with the code