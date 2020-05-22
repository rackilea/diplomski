public static void main(String[] args) {
    for (int r = 64, k = 9; k < 18; k++) {
        r += k + k - 1;
        System.out.printf("%d ", r);
    }
    System.out.println();
}