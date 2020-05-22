public static void main(String[] args) {
        int[][] tab1 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(Arrays.deepToString(tab1));
        System.out.println("---------------------------");
        int size = tab1.length * tab1[0].length;
        for(int i = 1; i <= size; i++){
            int j = size % i;
            if(j == 0){
                convert(tab1, i, size/i);
            }
        }

    }

    private static void convert(int[][] tab1, int row, int col) {
        System.out.println(String.format("converting to %dx%d", row, col));
        int[][] tab2 = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int index = i*col + j;
                int newRow = index / tab1[0].length;
                int newCol = index % tab1[0].length;
                tab2[i][j] = tab1[newRow][newCol];
            }
        }
        System.out.println(Arrays.deepToString(tab2));
        System.out.println("---------------------------");
    }