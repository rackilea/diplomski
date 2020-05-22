Map<String, List<String>> map = l.stream().map(s -> s.split("\\."))
        .map(s -> s.length > 1 ? s : new String[] {s[0], ""})
        .collect(
             Collectors.groupingBy(s -> s[0], 
                 Collectors.mapping(s -> s[1], 
                     Collectors.toList())));