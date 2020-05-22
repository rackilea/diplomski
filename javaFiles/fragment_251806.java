public static void testFunction() {
    Map<String, Function<Book, String>> mapToFunctions = new HashMap<>();

    Function<Book, String> myFunction = x -> new String(x.getTitle());

    mapToFunctions.put("firstfunction", myFunction);

    for (Function<Book, String> f : mapToFunctions.values()) {
        System.out.println(f.apply(new Book("my title")));
    }
}