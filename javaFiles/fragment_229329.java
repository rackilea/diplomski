try {
    URL url = new URL(getCodeBase(), "res/tileset_terrain.png");
    img = ImageIO.read(url);
} catch (IOException e) {
    e.printStackTrace();
}