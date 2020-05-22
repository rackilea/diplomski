List<String> list = Arrays.asList("A", "B", "C");
    List<String> combinations = list.stream()
        .reduce(Collections.<String>emptyList(),
            (sets, item) -> {
                return Stream.of(
                    sets.stream(),
                    Stream.of(item),
                    sets.stream().map(str->str+item)
                ).flatMap(x->x).collect(Collectors.toList());
            },
            (sets, sets2) -> { 
                throw new UnsupportedOperationException(
                    "Impossible error in sequential streams");
            }
        );
    System.out.println(combinations);