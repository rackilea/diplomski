public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("foo");
    list.add("bar");
    list.add("foobar");
    list.add("fubar");
    list.add("Hello World!");
    System.out.printf("String with length %s has index %s%n",
            5, getObjectIndexFromList(list, s -> s.length() == 5));
}