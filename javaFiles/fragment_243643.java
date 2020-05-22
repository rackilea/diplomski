public static void main(String[] args) {
    List<Tile> tileList = new ArrayList<Tile>();
    Tile masterGrassTile = new Tile(new Image("grass.png"), 0,0);

    Tile copyTile = new Tile(masterGrassTile);
    copyTile.getSprite().name = "water.png";

    System.out.println(masterGrassTile.getSprite().name); //Prints water.png
}