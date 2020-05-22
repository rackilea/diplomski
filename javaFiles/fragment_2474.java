//just once
int[][] occurrences = new int[X_MAX][Y_MAX];
for (Point p : points ) {
    occurrences[p.x][p.y]++;
}

//sometime later
if ( occurrences[x][y] != 0 ) {
    //contains Point(x, y)
}