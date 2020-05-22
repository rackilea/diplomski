screen.drawImage(
    tileSet.getTileImage().getSubimage(
        tileSet.getTileX(tile), 
        tileSet.getTileY(tile),
        tileSet.getTileWidth(), 
        tileSet.getTileHeight()),
    x,y,null);