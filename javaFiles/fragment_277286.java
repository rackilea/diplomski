try {
    URL url = new URL(getCodeBase(), "2.jpg");
    img = ImageIO.read(url);
} catch (IOException e) { 
    e.printStackTrace();
}