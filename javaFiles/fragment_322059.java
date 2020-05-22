char[][] arr = ... ;

// increments are -1, 0 or 1
int xIncrement = ... ;
int yIncrement = ... ;

// starting coordinates
int x = pX;
int y = pY;

while( ( y < arr.length ) && ( x < arr[y].length ) ) {

    char c = arr[y][x];

    // do something with c

    x += xIncrement;
    y += yIncrement;
}