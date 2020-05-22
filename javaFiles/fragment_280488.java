File file = new File("unknown.type.pic");
ByteArrayInputStream bais = new ByteArrayInputStream(FileUtils.readFileToByteArray(file);
BufferedImage image = ImageIO.read(bais);

ByteArrayOutputStream baos = new ByteArrayOutputStream();
ImageIO.write(image, "jpg", baos);

OutputStream outputStream = new FileOutputStream ("output.jpg"); 
baos.writeTo(outputStream);