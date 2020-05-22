public void calc(int n) {
    for (int o = 1; o <= n / 2; o += 2) {
        int p = 1;
        while (true) {
            int test = o * (int) Math.pow(2, p);
            if (test == n) { // solution found
                System.out.println("o:" + o + ", p:" + p);
                return;
            }
            if (test > n) break; // total value too high, lets start with another o
            p++;
        }
    }
}