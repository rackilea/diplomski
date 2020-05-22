url = "URL for xml file online"    
URL url_new = new URL(url);
HttpURLConnection connection = (HttpURLConnection) url_new.openConnection();
connection.setRequestMethod("GET");
BufferedInputStream inputStream = new BufferedInputStream(connection.getInputStream());
String xml_string = convertInputStreamToString(inputStream);