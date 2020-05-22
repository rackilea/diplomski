public static BufferedImage ImageDownloader(String urlString){
    BufferedImage image = null;
    try {
        String cleanUrl = urlString.replace(" ","%20");
        URL url = new URL(cleanUrl);
        image = ImageIO.read(url.openStream());
    } catch (IOException e) {
        e.printStackTrace();
    }
    return image;
}