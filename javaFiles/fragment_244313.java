for (FileInputStream inputStream : inputStreams) {
    ImageInputStream iis = ImageIO.createImageInputStream(inputStream);
    reader.setInput(iis);

    BufferedImage image = reader.read(0, null); // a) BufferedImage is returned! b) null param is fine!

    BufferedImage binarized = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_BINARY);

    // The following 7 lines is the important part you were missing:
    Graphics2D g = binarized.createGraphics();
    try {
        g.drawImage(image, 0, 0, null);
    }
    finally {
        g.dispose();
    }

    OutputStream out = new FileOutputStream("D:/Software/pdfbox-1.3.1.jar/tiff/MergedTiff.TIF");

    ImageIO.write(binarized, "tiff", out); // You probably want to check return value (true/false)!

    bufferedImages.add(image);
}