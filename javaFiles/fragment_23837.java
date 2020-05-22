int r = 7;
int c = 7;

int[][] matrix = new int[r][c];
for(int x=0; x<=r; x++)
    for(int y=0; y<r-x; y++){
        matrix[x][y] = Math.min(x, y);         //Update 1st diagonal half of the matrix
        matrix[r-x-1][c-y-1] = matrix[x][y];   //Update the next half (follow 1st half) 
    }