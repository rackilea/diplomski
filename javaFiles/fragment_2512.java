String imageData = parameterParser.getStringParameter("image", "");

    try {
        imageData = imageData.substring(22);
        byte[] imgByteArray = Base64.decodeBase64(imageData.getBytes());
        InputStream in = new ByteArrayInputStream(imgByteArray);
        BufferedImage bufferedImage = ImageIO.read(in);
        ImageIO.write(bufferedImage, "png", new File("/home/arvind/Desktop/test.png"));
    catch(Exception ex){
        ex.printStrackTrace();
    }