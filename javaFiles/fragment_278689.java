MimeMessage mimeMessage;

// mimeMessage get assigned

ByteArrayOutputStream output = new ByteArrayOutputStream();
mimeMessage.writeTo(output);
String rawEmail = output.toString();