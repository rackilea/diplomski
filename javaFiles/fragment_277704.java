class PropertyBasedMap implements TileBasedMap {

    private TiledMap map;
    private String blockingPropertyName;

    public PropertyBasedMap(TiledMap map, String blockingPropertyName) {
        this.map = map;
        this.blockingPropertyName = blockingPropertyName;
    }

    @Override
    public boolean blocked(PathFindingContext ctx, int x, int y) {
        // NOTE: Using getTileProperty like this is slow. You should instead cache the results. 
        // For example, set up a HashSet<Integer> that contains all of the blocking tile ids. 
        return map.getTileProperty(map.getTileId(x, y, 0), blockingPropertyName, "false").equals("true");
    }

    @Override
    public float getCost(PathFindingContext ctx, int x, int y) {
        return 1.0f;
    }

    @Override
    public int getHeightInTiles() {
        return map.getHeight();
    }

    @Override
    public int getWidthInTiles() {
        return map.getWidth();
    }

    @Override
    public void pathFinderVisited(int arg0, int arg1) {}

}