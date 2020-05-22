@Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector2 cell = screenToCell(screenX,screenY);
        System.out.println("selectedCell = "+cell.toString());

        //if you want to get the tile and the cell 
        TiledMapTileLayer layer = (TiledMapTileLayer)tiledMap.getLayers().get("Tile Layer 1");

        TiledMapTileLayer.Cell tileCell = layer.getCell((int) cell.x, (int) cell.y);
        TiledMapTile           tile     =  tileCell.getTile();

        //flip the tile just so you have a visual to make sure your selected the right tile
        tileCell.setFlipHorizontally(!tileCell.getFlipHorizontally());

        return true;
    }