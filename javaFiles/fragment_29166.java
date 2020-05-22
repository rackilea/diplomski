List<String> strings = l.stream()
        .flatMap(o -> {
                if (o instanceof List) {
                    return ((List<String>) o).stream();
                }
                return Stream.of((String) o);
            })
        .collect(Collectors.toList());