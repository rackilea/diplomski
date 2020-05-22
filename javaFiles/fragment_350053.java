public static <T> List<T> splitCommaSeparatedStringToList(String s, 
    Function<String, T> function) {
    if (isNull(s)) {
        return Collections.emptyList();
    }
    // Convert the array of String into a List of T
    return Arrays.stream(s.split(COMMA)).map(function).collect(Collectors.toList());
}