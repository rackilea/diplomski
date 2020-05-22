public static BufferedImage ImageDownloader(String urlString){
    BufferedImage image = null;
    try {
        URL url = new URL(urlString.replace(" ","%20"));
        image = ImageIO.read(url);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return image;
}