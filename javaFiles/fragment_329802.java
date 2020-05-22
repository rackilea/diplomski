BufferedImage img = ImageIO.read(new File("temp.jpg"));             
ByteArrayOutputStream baos = new ByteArrayOutputStream();
ImageIO.write(img, "jpg", baos);
baos.flush();
Base64 base = new Base64(false);
String encodedImage = base.encodeToString(baos.toByteArray());
baos.close();
encodedImage = java.net.URLEncoder.encode(encodedImage, "ISO-8859-1");
request.setRequestBody(encodedImage);