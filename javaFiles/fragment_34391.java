class Test2 {
  public static void main(String[] s) {
    long st = System.currentTimeMillis();

    List<String> l0 = new ArrayList<String>();
    l0.add("Hello");
    l0.add("World!");

    List<String> l1 = new ArrayList<String>();
    l1.add("Hello");
    l1.add("World!");

    /* snip */

    List<String> l999 = new ArrayList<String>();
    l999.add("Hello");
    l999.add("World!");

    System.out.println(System.currentTimeMillis() - st);
  }
}