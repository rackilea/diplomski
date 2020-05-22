class Euler9 {
  public static void main(String[] args) {
    int sum = 1000;
    for(int a = 1; a <= sum/3; a++) {
      for (int b = a + 1; b <= sum/2; b++) {
        int c = sum - a - b;
        if (a*a + b*b == c*c) {
          System.out.format("a=%d, b=%d, c=%d\n", a, b, c);
        }
      }
    }
  }
}