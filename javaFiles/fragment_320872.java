static Stream<Integer> parseIntStream(String s) {
    try {
        return Stream.of(Integer.parseInt(s));
    } catch (NumberFormatException nfe) {
        System.err.println(nfe.getMessage());
    }
    return Stream.empty();
}

intList = strList.stream()
            .flatMap(x -> parseIntStream(x))
            .collect(Collectors.toList());