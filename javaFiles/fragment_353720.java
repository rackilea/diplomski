public static Map<String, Result> calculateResults(List<String> list) {
    return list.stream().map(s -> new AbstractMap.SimpleImmutableEntry<>(s,
            firstFilter(s)? Result.RESULT1: secondFilter(s)? Result.RESULT2:
            thirdFilter(s)? Result.RESULT3: null))
        .filter(e -> e.getValue()!=null)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
}