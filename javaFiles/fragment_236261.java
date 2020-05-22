public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the dimension of the matrix : ");
        int dimension = Integer.parseInt(br.readLine());
        System.out.print("Enter the number of elements : ");
        int n = Integer.parseInt(br.readLine());   // total number of elements to be filled
        n = n/dimension;       // Get the number of rows and columns
        if(n % dimension != 0){
            // Not a Square matrix 
        }
        int circularArray[][] = new int[n][n];
        int k = 1, c1 = 0, c2 = n - 1, r1 = 0, r2 = n - 1;

        while (k <= n * n) {

            for (int i = c1; i <= c2; i++) {
                circularArray[r1][i] = k++;
            }

            for (int j = r1 + 1; j <= r2; j++) {
                circularArray[j][c2] = k++;
            }

            for (int i = c2 - 1; i >= c1; i--) {
                circularArray[r2][i] = k++;
            }

            for (int j = r2 - 1; j >= r1 + 1; j--) {
                circularArray[j][c1] = k++;
            }

            c1++;
            c2--;
            r1++;
            r2--;
        }

        /* Printing the Circular matrix */
        System.out.println("The Circular Matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(circularArray[i][j] + "\t");
            }
            System.out.println();
        }
    }