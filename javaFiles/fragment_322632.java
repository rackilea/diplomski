public static long countUpperCase(final String str) {
    // the 'var' keyword can be used with Java 10 or higher
    final var counter = new AtomicInteger(0);

    // convert a string into a List<Character>
    // Note that this is only applicable since Java 8 or higher
    var chars = str
            .chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.toList());

    // count the number of uppercase letters
    chars.forEach(c -> {
        if(Character.isUpperCase(c)) {
            counter.incrementAndGet();
        }
    });

    return counter.get();
}