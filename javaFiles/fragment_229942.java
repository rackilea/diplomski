//copy paste from linked site
Map<Integer, String> map = Stream.of(
            new SimpleEntry<>(0, "zero"),
            new SimpleEntry<>(1, "one"),
            //...
            new SimpleEntry<>(11, "eleven"),
            new SimpleEntry<>(12, "twelve"))
            .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue()));