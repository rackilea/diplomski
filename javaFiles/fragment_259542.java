e -> IntStream.range(0,
     e.getValue().size()).mapToDouble(
         n -> e.getValue().get(n % e.getValue().size())- e.getValue().get((n + 1)
                                          % e.getValue().size()))
     .boxed().collect(Collectors.teeing(Collectors.filtering((n -> n < 0),
                    Collectors.averagingDouble(a -> a)),
                                   Collectors.filtering((n -> n > 0),
                    Collectors.averagingDouble(a -> a)),
                               (a, b) -> Math.abs(a)+ Math.abs(b)))));

    System.out.println(result);