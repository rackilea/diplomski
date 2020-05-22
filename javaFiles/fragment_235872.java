private static final int HORIZONTAL = 1;
private static final int VERTICAL = 2;

private static final int S = 1;
private static final int E = 2;

private Random rand = new Random();

private void divide(int[][] grid, int x, int y, int width, int height, int orientation) {
    if(width < 2 || height < 2) {
        return;
    }
    boolean horizontal = orientation == HORIZONTAL;

    int wx = x + (horizontal ? 0 : rand.nextInt(width - 2));
    int wy = y + (horizontal ? rand.nextInt(height - 2) : 0);

    int px = wx + (horizontal ? rand.nextInt(width) : 0);
    int py = wy + (horizontal ? 0 : rand.nextInt(height));

    int dx = horizontal ? 1 : 0;
    int dy = horizontal ? 0 : 1;

    int length = horizontal ? width : height;

    int dir = horizontal ? S : E;

    for(int i = 0; i < length; i++) {
        if(wx != px || wy != py) {
            grid[wy][wx] |= dir;
        }
        wx += dx;
        wy += dy;
    }

    int nx = x;
    int ny = y;
    int w = horizontal ? width : wx - x + 1;
    int h = horizontal ? wy - y + 1 : height;
    divide(grid, nx, ny, w, h, chooseOrientation(w, h));

    nx = horizontal ? x : wx + 1;
    ny = horizontal ? wy + 1 : y;
    w = horizontal ? width : x + width - wx - 1;
    h = horizontal ? y + height - wy - 1 : height;
    divide(grid, nx, ny, w, h, chooseOrientation(w, h));
} 

private int chooseOrientation(int w, int h) {
    if(w < h) {
        return HORIZONTAL;
    } else if (h < w) {
        return VERTICAL;
    } else {
        return rand.nextInt(2) + 1;
    }
}