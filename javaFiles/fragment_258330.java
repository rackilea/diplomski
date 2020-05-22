public void fun(int[][] grid) {
    for(int row = 0; row < NUM; row++) {
        for(int col = 0; col < NUM; col++) {
            int counter = 0;

            if((row - 1) > 0 && (col - 1) > 0) {
                if(grid[row - 1][col - 1] == 0) {
                    counter++;
                }
            }

            if((row - 1) > 0 && (col + 1) < NUM) {
                if(grid[row - 1][col + 1] == 0) {
                    counter++;
                }
            }

            if((row + 1) < NUM && (col - 1) > 0) {
                if(grid[row + 1][col - 1] == 0) {
                    counter++;
                }
            }

            if((row + 1) < NUM && (col + 1) < NUM) {
                if(grid[row + 1][col + 1] == 0) {
                    counter++;
                }
            }

            grid[row][col] = counter;
        }
    }
}