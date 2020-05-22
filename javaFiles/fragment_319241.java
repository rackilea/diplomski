Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int q = scan.nextInt();
    int[] bits = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        bits[i] = scan.nextInt();
    }

    for (int i = 1; i <= q; i++) {
        if (scan.nextInt() == 1) {
            int index = scan.nextInt();
            if (bits[index] == 0) bits[index]++;
            else bits[index]--;
        } else {
            int lIndex = scan.nextInt();
            int rIndex = scan.nextInt();
            System.out.println(bits[rIndex] == 0 ? "EVEN" : "ODD");
        }
    }


}