public void test(String[] args) {
    List<String> coll1 = new ArrayList<>(Arrays.asList("A"));
    List<String> coll2 = new ArrayList<>(Arrays.asList("B","C"));
    coll1.retainAll(coll2);
    System.out.println(coll1);
}