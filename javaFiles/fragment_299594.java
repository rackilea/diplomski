class Main {
  public static void main(String[] args) {
    String pi = "3.14159265358979323846264338327950288419716939937...";
    for(int start=0, end=6; end <= pi.length(); start++, end++) {
      String substring = pi.substring(start, end);
      System.out.println(substring);
    }
  }
}