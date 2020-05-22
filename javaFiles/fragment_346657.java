Scanner scan = new Scanner(inputFile);

int[][] grid = new int[9][9];

for ( int i = 0; i < 9; i++ ) {
    for ( int j = 0; j < 9; j++ ) {
        if ( ! scanner.hasNextInt() ) {
             // exit with error since it couldn't read all 81 integers 
        }
        // read next integer into 9x9 grid array
        grid[i][j] = scanner.nextInt();
    }
}