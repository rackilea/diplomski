int xoffset = wallWidth() - tileWidth / 2;
int yoffset = xoffset * tileHeight / tileWidth;
int wallHeight = wallHeight() - tileHeight / 2 - yoffset;

for (int y = 3; y >= 0; y--) {
    for (int x = 5; x >= 0; x--) {

        int xCo = x * tileWidth / 2;
        int yCo = y * wallHeight - x * tileHeight / 2;

        walls.draw(g, xCo - xoffset, yCo - yoffset);
    }
}