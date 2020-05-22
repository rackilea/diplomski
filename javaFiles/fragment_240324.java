class Main {
  static <T extends List<Integer>> T add1(T lst) { ... }
  static List<Integer> add2(List<Integer> lst) { ... }
  public static void main(String[] args) {
    ArrayList<Integer> l = new ArrayList<Integer>();
    ArrayList<Integer> l1 = add1(l);
    ArrayList<Integer> l2 = add2(l); // ERROR!
  }
}