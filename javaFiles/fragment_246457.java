ByteArrayOutputStream output = new ByteArrayOutputStream();
output.write("something\r\n"".getBytes());
output.write("something\r\n"".getBytes());

ByteArrayOutputStream input = new ByteArrayInputStream(output.getBytes());
s3.putStream(input);