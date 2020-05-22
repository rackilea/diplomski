public void solve(int n, String start, String mid, String end) {
    if (n == 1) {
      System.out.println(a + " : "+ start + " to " + end);
      a++;
    } else {
      solve(n-1, start, end, mid);
      System.out.println(a + " : " + start + " to " + end);
      a++;
      solve(n-1, mid, start, end);
    }
  }