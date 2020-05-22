// Generate our data.
Map map = new Map();
map.generate();
// Draw to the screen.

// 1. Fill the entire screen with water.
for (int y = 0; y < HEIGHT; y++) {
    for (int x = 0; x < WIDTH; x++) {
        drawTile(x, y, Type.WATER);
    }
}

// 2. Draw the islands.
// We're going to use this algorithm to draw the circle:
// http://en.wikipedia.org/wiki/Midpoint_circle_algorithm
for (Island island : map.getIslands()) {
    int f = 1 - island.getRadius();
    int ddF_x = 1;
    int ddF_y = -2 * island.getRadius();
    int x = 0;
    int y = 0;

    Point2D center = island.getCenter();
    int radius = island.getRadius();
    drawTile(center.getX(), center.getY() + radius, TileType.LAND);
    drawTile(center.getX(), center.getY() - radius, TileType.LAND);
    drawTile(center.getX() + radius, center.getY(), TileType.LAND);
    drawTile(center.getX() - radius, center.getY(), TileType.LAND);

    while(x < y) {
        if(f >= 0) {
          y--;
          ddF_y += 2;
          f += ddF_y;
        }
        x++;
        ddF_x += 2;
        f += ddF_x;    
        drawTile(center.getX() + x, center.getY() + y, TileType.LAND);
        drawTile(center.getX() - x, center.getY() + y, TileType.LAND);
        drawTile(center.getX() + x, center.getY() - y, TileType.LAND);
        drawTile(center.getX() - x, center.getY() - y, TileType.LAND);
        drawTile(center.getX() + y, center.getY() + x, TileType.LAND);
        drawTile(center.getX() - y, center.getY() + x, TileType.LAND);
        drawTile(center.getX() + y, center.getY() - x, TileType.LAND);
        drawTile(center.getX() - y, center.getY() - x, TileType.LAND);
      }

      // TODO: Now you have to figure out how to fill in the guts of the island.
    }

// 3. Draw the deposits.
// TODO: I'll leave this one for you.