Map<String,Match> result =
    Stream.of(new Match("A", 1), new Match("A", 2), new Match("A", 4), new Match("A", 10),
              new Match("B", 3), new Match("B", 6), new Match("B", 12), new Match("C", 1))
        .collect(Collectors.groupingBy(Match::getType, Collectors.collectingAndThen(
            Collectors.reducing(BinaryOperator.maxBy(
                                    Comparator.comparingInt(Match::getScore))),
            Optional::get)));