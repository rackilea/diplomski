Map<String, String> x;
Map<String, Integer> y =
    x.entrySet().stream()
        .collect(Collectors.toMap(
            e -> e.getKey(),
            e -> Integer.parseInt(e.getValue())
        ));