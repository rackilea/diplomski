//  ENCODING
 BufferedImage img = ImageIO.read(new File("image.png"));    
 ByteArrayOutputStream baos = new ByteArrayOutputStream();
 ImageIO.write(img, "png", baos);    
 baos.flush();
 String encodedImage = Base64.encodeToString(baos.toByteArray());
 baos.close(); // should be inside a finally block
 node.setTextContent(encodedImage); // store it inside node

 // DECODING
 String encodedImage = node.getTextContent();
 byte[] bytes = Base64.decode(encodedImage);
 BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));