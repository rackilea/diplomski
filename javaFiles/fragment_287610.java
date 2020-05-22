View.prototype.draw = function() {
    var mapStartPos = [0, 0],
    worldStartPos = [0, 0],
    viewStartPos = [0, 0];
    mx, my, // map coordinates of current tile
    vx, vy; // view coordinates of current tile

    this.worldToMap(this.viewOrigin, mapStartPos); // which tile is closest to the view origin?
    this.mapToWorld(mapStartPos, worldStartPos);    // round world position to tile corner...
    this.worldToView(worldStartPos, viewStartPos);  // ... and then convert to view coordinates. this allows per-pixel scrolling

    mx = mapStartPos[0];
    my = mapStartPos[y];

    for (vy = viewStartPos[1]; vy < this.viewSize[1]; vy += TileHeight) {
        for (vx = viewStartPos[0]; vx < this.viewSize[0]; vy += TileWidth) {
            var tile = this.map.get(mx++, my);
            this.drawTile(tile, vx, vy);
        }
        mx = mapStartPos[0];
        my++;
        vy += TileHeight;
    }
};