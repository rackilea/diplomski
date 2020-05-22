for(int col = 0; col < m[row].length; col++){ //This is the real outer bubblesort loop. Change it to m[row].length
    for(int nextCol = col; nextCol < m[row].length; nextCol++) {
        if(m[row][col] > m[row][nextCol])
        {
           temp = //I'll let you figure this out
           m[row][col] = //....
           m[row][nextCol] = //...
        }
     }
}