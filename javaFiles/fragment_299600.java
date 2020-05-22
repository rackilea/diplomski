OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8); 
String s;

s = username.getText();
writer.write(s, 0, s.length());
writer.write(10);

s = password.getText();
writer.write(s, 0, s.length());
writer.write(10);