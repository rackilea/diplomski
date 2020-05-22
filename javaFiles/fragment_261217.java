public static void findValue(int[][] matrix, int n, int x){
    int i = 0, j = n-1;  //set indexes for top right element
    while ( i < n && j >= 0 ){
        if ( matrix[i][j] == x ){
            System.out.println("position of key: " + i + "," + j);
            return;
        }
        if ( matrix[i][j] > x ){
            j--;
        }else {
            i++;
        }
    }
    System.out.println("not found");
}

...
findValue(matrix, 4, 19);
...