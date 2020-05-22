ByteArrayOutputStream baos = new ByteArrayOutputStream();
ImageIO.write(image1, "png", baos); 
oos.writeObject(baos.toByteArray());
ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
ImageIO.write(image2, "png", baos2); 
oos.writeObject(baos2.toByteArray());