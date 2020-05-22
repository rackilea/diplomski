InputStream in = socket.getInputStream();
BufferedReader br = new BufferedReader(new InputStreamReader(in));
// The other side says hello:
String text = br.readLine();
// For whatever reason, you want to read one single byte from the stream,
// That single byte, just after the newline:
byte b = (byte) in.read();