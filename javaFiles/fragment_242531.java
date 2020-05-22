stream.collect(Collectors.collectingAndThen(Collectors.toList(),
    joiningLastDelimiter(", ", " and ")));

public static Function<List<String>, String> joiningLastDelimiter(
        String delimiter, String lastDelimiter) {
    return list -> {
                int last = list.size() - 1;
                if (last < 1) return String.join(delimiter, list);
                return String.join(lastDelimiter,
                    String.join(delimiter, list.subList(0, last)),
                    list.get(last));
            };
}