Observable.range(0, 10)
    .groupBy(i -> i % 2)
    .flatMap(g -> {
       if (g.getKey() % 2 == 0) 
         return g;
       else 
         return g.ignoreElements();
    })
    .subscribe(System.out::println, Throwable::printStackTrace);