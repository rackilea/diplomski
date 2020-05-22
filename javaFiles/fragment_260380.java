public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextInt()) {
        int toRead = scanner.nextInt();
        int[] vals = new int[toRead];
        for (int t = 0; t < toRead; t++) {
            if (scanner.hasNextInt()) {
                vals[t] = scanner.nextInt();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int n : vals) {
            sb.append(getSum(n)).append(" ");
        }
        System.out.println(sb);
    }
}