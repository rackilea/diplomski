//JSON funtion
    String cmd_getPhoto = so.cmd_getPhoto();

    //for remove ":"data:image\/png;base64,"
    String imageDataBytes = cmd_getPhoto.substring(cmd_getPhoto.indexOf(",") + 1);
    //for decode
    Base64 b = new Base64();
    byte[] decode = b.decode(imageDataBytes.getBytes());

    //create the stream
    InputStream stream = new ByteArrayInputStream(decode);

    try {
        //set the stream for a bufferedImage and do what your will with it
        BufferedImage bitmap = ImageIO.read(stream);
        jLabel6.setIcon(new ImageIcon(bitmap));
    } catch (IOException ex) {    }