for(int column = 0; line < MapHeight; column++)
{
    for(int line = 0; column < MapWidth; line++)
    {
        tileset.getSubImage(tilesX[line*MapWidth + column], tilesY[line*MapWidth + column]).drawEmbedded(i * TileWidth, j * TileHeight, TileWidth, TileHeight);
    }
}