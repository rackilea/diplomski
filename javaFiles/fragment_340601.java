public void handleTileClick(int x, int y, MouseEvent e) {
    if (player == Tile.EMPTY)
        return;
    boolean d = false;
    for (int[] dir : directions) {
        int dx = dir[0], dy = dir[1];
        int curX = x, curY = y;
        boolean c = false;
        while (true) {
            curX += dx;
            curY += dy;
            if (curX > 0 && curX < 8 && curY > 0 && curY < 8 && tiles[curX][curY].getState() == Tile.opposite(player))
                c = true;
            else {
                break;
            }
        }
        if (c && curX > 0 && curX < 8 && curY > 0 && curY < 8 && tiles[curX][curY].getState() == player) {
            do {
                curX -= dx;
                curY -= dy;
                tiles[curX][curY].setState(player);
            } while (curX != x || curY != y);
            tiles[x][y].setState(player);
            d = true;
        }
    }
    if (d)
        swapTurn();
}