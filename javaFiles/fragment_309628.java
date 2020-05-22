private void list() {
    List<String> l = new ArrayList<>();
    l.add("one");
    l.add("two");
    l.add("three");

    Future<Void> f = Future.succeededFuture();

    foldLeft(l.iterator(), f,
        (f1, s) -> f1.compose(ignore -> action(s)))
        .setHandler(res -> {
            System.out.println("completed");
        });
}

private static <A, B> B foldLeft(Iterator<A> iterator, B identity, BiFunction<B, A, B> bf) {
    B result = identity;
    while(iterator.hasNext()) {
        A next = iterator.next();
        result = bf.apply(result, next);
    }
    return result;
}