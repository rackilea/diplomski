private static int[][] mat;
private static int counter = 1;

public static void generare(int i, int j, int x, int y) {
    if (x - i <= 2 && y - j <= 2) {

        mat[i][j] = counter++;
        mat[i][j+1] = counter++;
        mat[i+1][j] = counter++;
        mat[i+1][j+1] = counter++;
    } else {
        generare(i, j, x/2+i/2, y/2+j/2);
        generare(i, j+(y-j)/2, x/2 +i/2, y);
        generare(i+(x-i)/2, j, x, y/2+j/2);
        generare(i+(x-i)/2, j+(y-j)/2, x, y);
    }
}

public static void main(String[] args) {
    int power=3;
    int n =(int) Math.pow(2, power);
    mat = new int[n][n];
    generare(0, 0, n, n);
    for(int i=0;i<n;i++) {
        for(int j=0; j<n; j++){
            System.out.print(mat[i][j] +" ");
        }
        System.out.println();
    }
}