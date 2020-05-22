void <V, M extends SomeBaseM> annoyingCaller(
        Class<? extends V> v,
        Class<? extends M> m) {
    final MyTransformer<V, M> transformer = new MyTransformer<>();
    transformer.method();
    ...
}