public int setMap(int map)
{
  currentMap.dispose(); // Dispose your map first
  currentMap = map;
  tiledMap = MyGdxGame.getAssetManager().get(Integer.toString(currentMap) + ".tmx");
  tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
  return currentMap;
}