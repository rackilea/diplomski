compression-quality-when-saving-images-in-java
        Iterator<ImageWriter> iter = ImageIO
                .getImageWritersByFormatName("jpeg");
        ImageWriter writer = (ImageWriter) iter.next();
        // instantiate an ImageWriteParam object with default compression
        // options
        ImageWriteParam iwp = writer.getDefaultWriteParam();
        iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        iwp.setCompressionQuality(1); // an integer between 0 and 1
        // 1 specifies minimum compression and maximum quality
        File file = new File("C:\\Users\\ad min\\Pictures\\scaleddown.jpg");
        FileImageOutputStream output = new FileImageOutputStream(file);
        writer.setOutput(output);
        IIOImage image = new IIOImage(rescaled, null, null);
        writer.write(null, image, iwp);
        writer.dispose();