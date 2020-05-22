int[] left = new int[] { 1, 5, 3 };
    int[] right = new int[] { 10, 15, 13 };

    IntStream.range(0, left.length)
            .boxed()
            .map(x -> new AbstractMap.SimpleEntry<>(left[x], right[x]))
            .sorted(Comparator.comparing(SimpleEntry::getKey))
            .forEach(System.out::println);