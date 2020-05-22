Integer[] second = IntStream.range(0, left.length)
            .boxed()
            .map(x -> new AbstractMap.SimpleEntry<>(left[x], right[x]))
            .sorted(Comparator.comparing(SimpleEntry::getKey))
            .map(SimpleEntry::getValue)
            .toArray(Integer[]::new);