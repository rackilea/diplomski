InputStream inputStream = exec.getInputStream();
BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
String line = null;
while((line = br.readLine()) != null) {
    System.out.println(line);
}