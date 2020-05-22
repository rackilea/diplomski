BufferedReader br = new BufferedReader(new FileReader("input_file_path"));
String line;
while ((line = br.readLine()) != null) {
   // Process the string into whatever format you need
}
br.close();