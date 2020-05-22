public void fun(int[][] grid) {
    for(int row = 0; row < NUM; row++) {
        for(int col = 0; col < NUM; col++) {
            if((grid[row][col] % 2) == 0) {
                grid[row][col] = 0;
            }
        }
    }

    for(row = 0; row< NUM; row++){
        for(int col = 0; col < NUM; col++) {
            int count = 0;

            // To check for the 1st Diagonal Neighbor
            if((row-1)>0 && (col-1)>0){
                if(grid[row-1][col-1]==0){
                    count++;
                }
            }

            //Similarly for 2nd, 3rd and 4th Diagonal Neighbors

            //and then
            grid[row][col]=count;
        }
    }

}