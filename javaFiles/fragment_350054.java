public static <T> List<T> splitCommaSeparatedStringToList(String s, 
    Function<String, T> function) {
    if (isNull(s)) {
        return Collections.emptyList();
    }
    return FluentIterable.from(Arrays.asList(s.split(COMMA))).transform(function).toList();
}