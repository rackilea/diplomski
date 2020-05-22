public static int[] toIso(int x, int y){

    int i = (x - y) * TILE_WIDTH_HALF;
    int j = (x + y) * TILE_HEIGHT_QUARTER;

    i += xOffset-TILE_WIDTH_HALF;
    j+=yOffset;

    return new int[]{i,j};
}

public static int[] toGrid(double i, double j){

    i-=xOffset;
    j-=yOffset;

    double tx = Math.ceil(((i / TILE_WIDTH_HALF) + (j / TILE_HEIGHT_QUARTER))/2);
    double ty = Math.ceil(((j / TILE_HEIGHT_QUARTER) - (i / TILE_WIDTH_HALF))/2);

    int x = (int) Math.ceil(tx)-1;
    int y = (int) Math.ceil(ty)-1;

    return new int[]{x, y};
}