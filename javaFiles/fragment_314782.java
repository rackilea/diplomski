Map<String, List<String>> res = books.entrySet()
            .stream()
            .flatMap(x -> Arrays.stream(x.getValue().split("\\s"))
                                .map(y -> new AbstractMap.SimpleEntry<>(y, x.getKey())))
            .collect(Collectors.groupingBy(
                    Entry::getKey,
                    Collectors.mapping(Entry::getValue, Collectors.toList())));