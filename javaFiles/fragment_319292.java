// Fixed search URL; drop openConnection() at the end
URL url = new URL("http://google.com/search?q=" + query);

// Setup connection properties (this doesn't open the connection)
URLConnection connection = url.openConnection();
connection.setRequestProperty("Accept-Charset", "UTF-8");

// Actually, open the HTTP connection
connection.connect();

// Setup a reader
BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));

// Read line by line
String line = null;
while ((line = reader.readLine()) != null) {
     System.out.println (line);
}

// Close connection
reader.close();