TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(0);
    TiledMapTileSet tileset = map.getTileSets().getTileSet(0);

    Array<StaticTiledMapTile> at = new Array<StaticTiledMapTile>();
    if (tileset.getTile(0) != null) at.add((StaticTiledMapTile) tileset.getTile(0));
    if (tileset.getTile(1) != null) at.add((StaticTiledMapTile) tileset.getTile(1));
    if (tileset.getTile(2) != null) at.add((StaticTiledMapTile) tileset.getTile(2));
    if (tileset.getTile(3) != null) at.add((StaticTiledMapTile) tileset.getTile(3));

    layer.getCell(2, 2).setTile(new AnimatedTiledMapTile(0.3f, at));