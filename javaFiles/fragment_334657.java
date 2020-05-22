StringBuilder text = new StringBuilder();

try {

BufferedReader br = new BufferedReader(new FileReader(file));
String line;

while ((line = br.readLine()) != null) {
    text.append(line);
    text.append('\n');
}
br.close();
  }
catch (IOException e) {

//error handling here