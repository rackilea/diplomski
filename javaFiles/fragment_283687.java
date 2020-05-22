class A {
    static Map<Set<String>, String> lut = new HashMap<Set<String>, String>() {{
        put(new HashSet<String>(Arrays.asList("x", "y")), "foo");
        put(new HashSet<String>(Arrays.asList("x", "y", "z")), "bar");
    }};
    public static void main(String[] args) {
        System.out.println(lut.get(new HashSet<String>(Arrays.asList("x", "y"))));
    }
}