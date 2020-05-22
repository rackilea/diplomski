for(int col = 0; col < numTilesAcross; col++) {
        BufferedImage[] subimage = new BufferedImage[s.length];
        subimage[0] = tileset[0].getSubimage(
                    col * tileSize,
                    0,
                    tileSize,
                    tileSize
                );
        tiles[0][col] = new Tile(subimage, Tile.NORMAL);
        subimage[0] = tileset[0].getSubimage(
                    col * tileSize,
                    tileSize,
                    tileSize,
                    tileSize
                );
        tiles[1][col] = new Tile(subimage, Tile.BLOCKED);
    }