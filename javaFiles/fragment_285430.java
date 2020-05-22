public static void main(String[] args){
    int rows = 6;
    int[][] triangle = new int[rows][rows];

    for (int i = 1 ; i <= rows  ; i++){
        for (int j = 0 ; j < i ; j++){
            if (j == 0) triangle[i-1][j] = 1;
            else triangle[i-1][j] = triangle[i-2][j-1] + triangle[i-2][j];
            System.out.print(triangle[i-1][j] + " ");
        }
        System.out.println();
    }
}