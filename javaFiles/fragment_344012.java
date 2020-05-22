InputStream input = getClass().getResourceAsStream("names.txt");
BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
String line = null;

while ((line = reader.readLine()) != null) {
    // ...
}