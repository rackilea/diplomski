class VarargTest {
  public static void main(String[] args) {
    Object[] params = {"x", 1.2345f};
    String s = String.format("%s is %.2f", params);
    System.out.println(s); // Output is: x is 1.23
  }
}