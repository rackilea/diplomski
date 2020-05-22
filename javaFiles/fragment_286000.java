IntStream.rangeClosed(this.getYear(), to.getYear())
    .boxed()
    .map(i -> Arrays
        .stream(Quarters.values())
        .map(q -> new Quarter(i, q))
        .flatMap(Function.identity())
    );