public static void computeRow(int n) {
    int counter;
    for (int i = 0; i < n; i++) {
        // only output the line if it be the last one
        if (i == n-1) {
            for (int j = 0; j <= i; j++) {
                System.out.print(pascalValue(i, j) + " ");
            }
            System.out.println();
        }
    }
}

public static void main(String[] args) {
    computeRow(5);
}