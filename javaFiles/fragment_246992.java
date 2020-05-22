Observable.just(1, 2, 3)
    .groupBy(k -> k % 3)
    .flatMap(g -> g.takeLast(1))
    .count()
    .toBlocking()
    .forEach(System.out::println);