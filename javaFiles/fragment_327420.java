public static void main(String[] args) {
    Foo f = new Foo();
    List<String> list1 = f.getList("a", "b");
    System.out.println(list1);
    List<String> list2 = f.getList("c", "d");
    System.out.println(list2);
    System.out.println(list1);
}

static class Foo {
    public List<String> getList(String... strings) {
        List<String> result = new ArrayList<String>();
        result.addAll(Arrays.asList(strings));
        return result;
    }
}