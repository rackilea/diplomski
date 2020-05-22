System.out.print("Enter the row and column size of matrix : ");
String[] mn = sc.nextLine().split("\\s+");
int M = Integer.parseInt(mn[0]);
int N = Integer.parseInt(mn[1]);
System.out.println();

double[][] matrixX = new double[N][];
for (int i = 0; i < N; i++) {
    matrixX[i] = new double[M];
    String[] row = sc.nextLine().split("\\s+");
    for (int j = 0: j < M: j++) {
        matrix[i][j] = Double.parseDouble(row[j]);
        //... 
    } 
}