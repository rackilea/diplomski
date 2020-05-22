public static void main(String args[]) {
    final int m = 9; // Rows
    final int n = 9; // Columns
    Scanner s1 = new Scanner(System.in);
    int i, j;

    int myArray1[][] = new int[m][n]; // Original array, m rows n cols
    int myArray2[][] = new int[n][m]; // Transposed array, n rows m cols

    // Input
    for (i = 0; i < m; i++) {
        for (j = 0; j < n; j++) {
            // Should be only prompt.
            // Improved to show which entry will be affected.
            System.out.printf("[%d][%d]" + "Enter array from 1 to 9\n", i, j); 
            myArray1[i][j] = s1.nextInt();
        }
    }

    // Transposing now (watch for the ordering of m, n in loops)...
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < m; j++)
        {
            myArray2[i][j] = myArray1[j][i];
        }
    }

    // After transposing, output
    System.out.print("Your array is:\n");
    for (i = 0; i < m; i++) {
        for (j = 0; j < n; j++) {
            System.out.print(myArray1[i][j] + " ");
        }
        System.out.println(); // New line after row is finished
    }

    System.out.print("Your transposed array is:\n");
    for (i = 0; i < n; i++) {
        for (j = 0; j < m; j++) {
            System.out.print(myArray2[i][j] + " ");
        }
        System.out.println();
    }
    s1.close();
}