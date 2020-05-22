BufferedImage bi = getBufferedImage(imageIcon.getImage());
ByteArrayOutputStream baos = new ByteArrayOutputStream();
ImageIO.write(bi, formatType, baos);

byte[] byteArray= baos.toByteArray();

preparedStatement.setBytes(1, byteArray);