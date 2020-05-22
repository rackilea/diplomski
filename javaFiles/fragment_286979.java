String encoding = "UTF-8";
BufferedReader in =
    new BufferedReader(new InputStreamReader(connection.getInputStream(),
                                             encoding));
String line;
while((line = in.readLine()) != null) {
    System.out.println(line);
}