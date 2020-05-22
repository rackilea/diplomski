static final Pattern SPACE = Pattern.compile("\\s+");

public static <T> Predicate<T> getFilter(Function<? super T, String> f, String words) {
    String regex = SPACE.splitAsStream(words)
        .map(Pattern::quote).collect(Collectors.joining("|"));
    Predicate<String> sp = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).asPredicate();
    return t -> sp.test(f.apply(t));
}