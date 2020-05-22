public void testPut() {
    System.out.println("put");
    Name name0 = new Name("abc");
    Name name1 = new Name("abc");
    TernarySearchTree<Name> instance = new TernarySearchTree<Name>();
    instance.put(name0.toString(), name0);
    instance.put(name1.toString(), name1);
    assertEquals(2, instance.matchPrefix("a").size()); // fail here. Result is 1
}