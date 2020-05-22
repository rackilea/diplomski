IntStream.rangeClosed(this.getYear(), to.getYear())
    .boxed()
    .flatMap(i -> Arrays
        .stream(Quarters.values())
        .map(q -> new Quarter(i, q))
    );