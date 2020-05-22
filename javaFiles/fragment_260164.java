Charset charset = Charset.forName("ISO-8859-1");
Byte[] bytes: Array[Byte] = cam_data.getBytes(charset)
File f = new File("image.jpeg")
FileImageOutputStream fios = new FileImageOutputStream(f)
BufferedImage  bim = ImageIO.read(new ByteArrayInputStream(bytes))
ImageIO.write(bim,"jpeg",fios)