if (c && tiles[curX][curY].getState() == player) {
    do {
        curX -= dx;
        curY -= dy;
        tiles[curX][curY].setState(player);
    } while (curX != x || curY != y);

    tiles[x][y].setState(player);
    d = true;
}