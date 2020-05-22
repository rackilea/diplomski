int c0 = scanner.nextInt();
int c1 = scanner.nextInt();

for (int i=0; i < row; i++) {
    int temp = matrix[i][c0];
    matrix[i][c0] = matrix[i][c1];
    matrix[i][c1] = temp;
}