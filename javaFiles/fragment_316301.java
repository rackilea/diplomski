public static void main(String[] args) {
  List<Integer> list = new ArrayList<Integer>();
  list.add(1);
  list.add(2);
  int total = list.get(0); // <-- You even use 0 here!
  System.out.println(total);
}