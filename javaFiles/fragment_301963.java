public static int charArea (char[][] grid, char ch) {
    int[] first = new int[] {100, 100};
    int[] last = new int[] {-1, -1};

    for (int i=0; i<3; i++) { 
        for (int j=0; j<4; j++) {
               if(grid[i][j]==ch) {
                  first[0] = Math.min(i, first[0]);
                  first[1] = Math.min(j, first[1]);
                  last[0] = Math.max(i, last[0]);
                  last[1] = Math.max(j, last[1]);
               }
        }
    }

    int answer = (last[0] - first[0] + 1) * (last[1] - first[1] + 1);

    return answer;
}