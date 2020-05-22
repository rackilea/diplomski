OutputStream os = channel.getOutputStream();
PrintWriter writer = new PrintWriter(os);
InputStream is = channel.getInputStream();
BufferedReader reader = new BufferedReader(new InputStreamReader(is));
channel.connect();
writer.println("ls -l");
String response = reader.readLine();
while(response != null) {
    // do something with response
    response = reader.readLine();
}
writer.println("pwd");