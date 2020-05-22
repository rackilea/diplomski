Set<String> set1 = parsedLocal.stream()
        .map{it.toUpperCase()}
        .collect(Collectors.toSet());
List<String> retained = parsedRemote.stream()
        .filter{!set1.contains(it.toUpperCase())}
        .collect(Collectors.toList());