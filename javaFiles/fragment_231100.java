HtmlImage img = (HtmlImage) p.getByXPath("//img").get(3);
ImageReader imageReader = img.getImageReader();
BufferedImage bufferedImage = imageReader.read(0);
String formatName = imageReader.getFormatName();
ByteArrayOutputStream byteaOutput = new ByteArrayOutputStream();
Base64OutputStream base64Output = new base64OutputStream(byteaOutput);
ImageIO.write(bufferedImage, formatName, base64output);
String base64 = new String(byteaOutput.toByteArray());