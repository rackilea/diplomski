public static void main(String[] args) {
    Foo f = new Foo();
    List<String> list1 = f.getList("a", "b");
    System.out.println(list1);
    List<String> list2 = f.getList("c", "d");
    System.out.println(list2);
    System.out.println(list1);
}

static class Foo {
    private List<String> myList = new ArrayList<String>();
    public List<String> getList(String... strings) {
        myList.clear();
        myList.addAll(Arrays.asList(strings));
        return myList;
    }
}