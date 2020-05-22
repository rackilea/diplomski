public BufferedImage loadImage(String fileName){

    BufferedImage buff = null;
    try {
        buff = ImageIO.read(getClass().getResourceAsStream(fileName));
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return null;
    }
    return buff;

}