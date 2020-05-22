public static void main(String[] args) throws java.lang.Exception {
    int n, k;
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    k = in.nextInt();
    int total = 0;
    int values[] = new int[n];
    for (int i = 0; i < n; i++) {
        values[i] = in.nextInt();
        if ((values[i] % k) == 0) {
            total++;
        }
    }
    System.out.println(total);
}