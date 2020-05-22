public static void main(String[] args) {
    for (int k = 9; k <= 17; k++) {
        int t = 0;
        for (int j = 0; j < k; j++) {
            t += k;
        }
        System.out.print(t + " ");
    }
    System.out.println();
}