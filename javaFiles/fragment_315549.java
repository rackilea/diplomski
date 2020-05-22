class Test {
  public static void main(String[] args) {
    String[] tests = {"-100", "", "2334", "0"};
    for(String t : tests) {
      System.out.println(t + " -> " + t.matches("\\d*"));
    }
  }
}