public static void main(String[] args) {
    LinkedHashMap<String, String> test = new LinkedHashMap<String, String>();
    test.put("a", "1");
    test.put("b", "2");
    test.put("c", "3");
    test.put("d", "4");

    System.err.println(test);
    test.clear();
    System.err.println(test);
}