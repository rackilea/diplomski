public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter the desired amount of rows for the matrix: ");
    int rows = s.nextInt();
    System.out.print("Enter the desired amount of columns for the matrix: ");
    int columns = s.nextInt();
    int[][] matrix = new int[rows][columns];
    System.out.println("Enter the matrix values one row at a time.");
    for(int i = 0; i < rows; i++)
    {
        for(int j = 0; j < columns; j++)
            matrix[i][j] = s.nextInt();
    }
}