static void traverse(int[] ar) {
    for (int i = 0; i < ar.length - 1; i++) {
        for (int j = i + 1; j < ar.length; j++) {
            System.out.printf("(%d,%d) ", ar[i], ar[j]);
        }
    }
}