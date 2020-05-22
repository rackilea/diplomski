InputStream is = new FileInputStream("utf8file.txt");
BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));

// Read text, file will be read as UTF-8
String line = in.readLine();

in.close();