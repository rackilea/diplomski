public static void main(String[] args) {
        List<String> names = new ListWithDefault<String>(
            Arrays.asList("Alice", null, "Bob", "Carol", null),
            "UNKNOWN"
        );

        for (String name : names) {
            System.out.println(name);
        }
        // Alice
        // UNKNOWN
        // Bob
        // Carol
        // UNKNOWN

        System.out.println(names);
        // [Alice, null, Bob, Carol, null]
}