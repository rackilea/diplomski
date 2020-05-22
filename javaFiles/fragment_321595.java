public static void main(String[] args) {
    boolean [][] a;
    int N = Integer.parseInt(args[0]);
    a = new boolean [N][N];

    System.out.print("  "); //print the spacer for the row numbers
    for (int i = 0; i < N; i++){
         System.out.print(i + " "); //print the column number
    }

    for (int i = 0; i<a.length;i++){ 
        System.out.print("\n" + i + " "); //new line plus row number

        for (int j = 0; j<a[0].length;j++){
            a[i][j] = true; 
            int sum = (i+j);

            if (sum%3==0) {
                System.out.print("T ");
            } else {
                System.out.print("F ");
            }
        }
    }
}