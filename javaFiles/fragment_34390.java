class Test1 {
  public static void main(String[] s) {
    long st = System.currentTimeMillis();

    List<String> l0 = new ArrayList<String>() {{
      add("Hello");
      add("World!");
    }};

    List<String> l1 = new ArrayList<String>() {{
      add("Hello");
      add("World!");
    }};

    /* snip */

    List<String> l999 = new ArrayList<String>() {{
      add("Hello");
      add("World!");
    }};

    System.out.println(System.currentTimeMillis() - st);
  }
}