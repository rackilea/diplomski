public static void main(String[] args) throws Exception {
    Map<String, String> m = new LinkedHashMap<> (16, 0.75f, true);

    m.put("a", "a");
    m.put("b", "b");
    System.out.println("m = " + m); // a, b
    m.put("a", "a");
    System.out.println("m = " + m); // b, a

    Map<String, String> m2 = new LinkedHashMap<>();
    m2.put("b", "b");

    m.putAll(m2);
    System.out.println("m = " + m); // a, b: putAll was considered as an access
                                    // and the order has changed
}