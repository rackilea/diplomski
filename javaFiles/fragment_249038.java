Process p = Runtime.getRuntime().exec(str);
InputStreamReader reader = p.getInputStream();
BufferedReader buffer = new BufferedReader(reader);
String line = null;
while ((line = buffer.readLine() != null) {
  //write stuff to file here
}