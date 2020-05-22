public static void main(String[] args) {
    Random r = new Random();
    int[] counts = new int[600];
    for (int i = 0; i < 400; i++) {
        counts[r.nextInt(600)]++;
    }
    int n = 0;
    for (int i = 0; i < 600; i++) {
        if (counts[i] == 0) {
            n++;
        }
    }
    System.out.println(100.0 * n / 600);
}