public static void main(String args[]) throws Exception {

    //Write code here
    Scanner sc = new Scanner(System.in);
    System.out.println("Input Rows: ");
    int m = sc.nextInt();
    System.out.println("Input Coloumns: ");
    int n = sc.nextInt();
    System.out.println("Enter values: ");
    int[][] arr = new int[m][n];

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (i==0 && j==0 || i==m-1 && j==n-1) {
                continue;
            } else {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println();
    }
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            System.out.print(arr[i][j] + " ");
        }
        System.out.println();
    }

}