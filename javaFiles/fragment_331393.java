ByteArrayOutputStream out = new ByteArrayOutputStream();
ImageIO.write(bi, "PNG", out);
byte[] bytes = out.toByteArray();

String base64bytes = Base64.encode(bytes);
String src = "data:image/png;base64," + base64bytes;