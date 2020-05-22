public static String matrixToString(int[][] a){
    int m = a.length;
    int n = a[0].length;

    String tmp = "";
    for(int y = 0; y<m; y++){
        for(int x = 0; x<n; x++){
            tmp = tmp + a[y][x] + " ";
        }
        tmp = tmp + "\n";
    }

    return tmp;
}