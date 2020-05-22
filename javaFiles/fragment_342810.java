void removeChest(int tileRow, int tileColumn) {
    final TMXTile tileToReplace = tmxMap.getTMXLayers().get(0).getTMXTile(tileColumn, tileRow);
    final int w = tileToReplace.getTileWidth();
    final int h = tileToReplace.getTileHeight();
    Sprite sprite = new Sprite(w * (tileColumn + 0.5), h * (tileRow + 0.5), textureRegionOfGround, this.getVertexBufferObjectManager());
    scene.addChild(sprite);
}