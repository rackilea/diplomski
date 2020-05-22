BufferedImage originalImage = ImageIO.read(new File("path to file"));
ByteArrayOutputStream baos = new ByteArrayOutputStream();
ImageIO.write( originalImage, "jpg", baos );
baos.flush();

MultipartFile multipartFile = new MultipartImage(baos.toByteArray());