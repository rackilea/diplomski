// Sending side
byte[] data = text.getBytes(StandardCharsets.UTF_8);
String base64 = Base64.encodeToString(data, Base64.DEFAULT);

// Receiving side
byte[] data = Base64.decode(base64, Base64.DEFAULT);
String text = new String(data, StandardCharsets.UTF_8);