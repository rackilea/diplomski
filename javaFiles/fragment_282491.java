public static BufferedImage ImageDownloader(String urlString){
    BufferedImage image = null;
    try {
        String cleanUrl = urlString.replace(" ","%20");
        URL url = new URL(cleanUrl);
        URLConnection connection = url.openConnection();
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        image = ImageIO.read(inputStream);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return image;
}