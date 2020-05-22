public static void placeBoat(char [][] boat, int x, int y){
    // the first part is at y
    boat [x][y] = '>';

    // size is 5 because there 5 more parts to the boat
    int[] nextYs = new int[5];

    for (int j = 0; j < nextYs.length; j++) {
        // next y is at y - 1
        int nextY = y - 1;

        // next y is to the left
        if (nextY >= 0) {
            // set y to - 1
            y = y - 1;
        // next Y is to the right
        } else {
            // next y and y itself should be set to the last column
            nextY = y = boat[x].length - 1;
        }

        nextYs[j] = nextY;
    }

    // print the other parts                
    boat [x][nextYs[0]] = '=';
    boat [x][nextYs[1]] = '|';
    boat [x][nextYs[2]] = '|';
    boat [x][nextYs[3]] = '=';
    boat [x][nextYs[4]] = '<';
}