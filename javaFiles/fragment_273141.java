boolean isHorizontallySymmetrical(char[][] grid, int n){
    int across = n / 2;

    for(int i = 0; i < n; i++){
        int right = 0
        for(int left = 0; left < across; left++){
            right = n - left - 1;

            if(grid[i][left] != grid[i][right]){
                return false;
            }
        }
    }

    return true;
}