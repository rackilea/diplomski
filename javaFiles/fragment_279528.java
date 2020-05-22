Barcode39 barcode = new Barcode39();
barcode.setCode("7001390283546141");
barcode.setBarHeight(40);

Image img = barcode.createAwtImage(Color.BLACK, Color.WHITE);

BufferedImage outImage = new BufferedImage(img.getWidth(null), img.getHeight(null),BufferedImage.TYPE_INT_RGB);

outImage.getGraphics().drawImage(img, 0, 0, null);
ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
ImageIO.write(outImage, "png", bytesOut);
bytesOut.flush();
byte[] pngImageData = bytesOut.toByteArray();
FileOutputStream fos = new FileOutputStream("C:/results/barcode.jpg");
fos.write(pngImageData);
fos.flush();
fos.close();