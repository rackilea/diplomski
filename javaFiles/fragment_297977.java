List<String> unique = 
 strings.stream()
        .map(str -> new LinkedHashSet<>(Arrays.asList(str.split(","))))
        .distinct()
        .map(set -> set.stream().collect(Collectors.joining(",")))
        .collect(Collectors.toList());