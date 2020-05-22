HttpURLConnection retHttpURLConnection = (HttpURLConnection) urlToConnect.openConnection();
retHttpURLConnection.setRequestMethod("POST");
retHttpURLConnection.setRequestProperty("Connection", "keep-alive");
//Some work code and then 
os = connection.getOutputStream();
//Some work with response
os.close();