public static void main(String[] args) {
  Object o = null;
  System.out.println(empty(o));
  System.out.println(empty(""));
  System.out.println(empty("as"));
  System.out.println(empty(new int[0]));
  System.out.println(empty(new int[] { 1, 2}));
  System.out.println(empty(Collections.emptyList()));
  System.out.println(empty(Arrays.asList("s")));
  System.out.println(empty(0));
  System.out.println(empty(1));
}