DataOutputStream dos = new DataOutputStream(outputStream);
byte[] bytes;
int len;

bytes = username.getText().getBytes(StandardCharsets.UTF_8);
len = bytes.length;
dos.writeInt(len);
dos.write(bytes, 0, len);

bytes = password.getText().getBytes(StandardCharsets.UTF_8);
len = bytes.length;
dos.writeInt(len);
dos.write(bytes, 0, len);