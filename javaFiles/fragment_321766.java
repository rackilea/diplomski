byte[] bytes = new byte[1024];
String base64String = "";
while (stream.read(bytes) != -1) {
    String tmp = new String(bytes, StandardCharsets.UTF_8);
    base64String += tmp;
}