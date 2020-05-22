Socket client = server.accept();
OutputStream os = client.getOutputStream();

BufferedReader br = new BufferedReader( new InputStreamReader(Files.newInputStream(file.toPath())));
String str;
while ((str = br.readLine()) != null && str.length() > 0) {
     os.write((str).getBytes());
}
br.close();
os.close();