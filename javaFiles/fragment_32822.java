public static void main(String[] args) {
    int k = Integer.parseInt(args[0]);
    for (int n = 0; n < k; n++) {
      printSpaces(k - 1 - n); // k-1 at n=0 and 0 at n=k-1!
      printRowVisiblePart(n);
    }
  }