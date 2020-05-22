List<Long> ids = Arrays.asList(1L, 2L, 3L);
      Observable<List<Long>> regUsers = Observable.just(Arrays.asList(1L, 2L)).cache();

      Observable<Long> idsStream = Observable.from(ids).cache();
      Observable<Boolean> containsStream = idsStream
             .concatMap(id -> regUsers.map(regList -> regList.contains(id)));

      idsStream.zipWith(containsStream, (Func2<Long, Boolean, Pair>) Pair::new)
            .toMap(Pair::getLeft, Pair::getRight).subscribe(System.out::println);


  private static class Pair<K, V> {

    private final K left;
    private final V right;

    public Pair(K left, V right) {
        this.left = left;
        this.right = right;
    }

    public K getLeft() {
        return left;
    }

    public V getRight() {
        return right;
    }
}