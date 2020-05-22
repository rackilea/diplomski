try {
    BufferedImage img = 
        ImageIO.read(this.getClass().getResourceAsStream("resources/"+filename));
} catch (IOException e) {
    e.printStackTrace();
}