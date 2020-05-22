String saveLocation = "/Images/questionMark.png";
InputStream inputStream = this.getClass().getResourceAsStream(saveLocation);
try {
    BufferedImage img = ImageIO.read(inputStream);
} catch (IOException e) {
    e.printStackTrace();
}