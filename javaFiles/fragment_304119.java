int[][] world = new int[50][50];

for( int i = 0; i < 50; i++ ){
    for( int b = 0; b < 50; b++ ){
        int tile = world[i][b];
        render(tile, i, b);
        //use i and b to position the tile on your world