public enum Tile {
    GROUND("ground.png"), WALL("wall.png");
    final Image image;
    Tile(String filename) {
        image = getImage(filename);
    }
    Image getImage(String filename) {
        try {
            return ImageIO.read(new File("assets/game/tiles/" + filename));
        } catch (IOException io) {
            io.printStackTrace();
            return null;
        }
    }
}