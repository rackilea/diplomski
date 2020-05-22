Image tile = new Image("tile.png");

Group house = new Group();
house.setCache(true);
house.setCacheHint(CacheHint.SPEED);

Effect lighting = new Lighting();

for (int i = 0; i < houseWidth; i++) {
  // here is the critical part => don't do new ImageView(new Image("tile.png"))
  ImageView tileView = new ImageView(tile));
  tileView.setEffect(lighting);
  tileView.setCache(true);
  tileView.setCacheHint(CacheHint.SPEED);

  house.add(tileView);  
}