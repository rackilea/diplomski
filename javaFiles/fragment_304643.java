public static <V> List<V> get(Future<V>... futures) throws ExecutionException, InterruptedException {
    List<V> values = new ArrayList<>();
    for (int i = 0; i < futures.length; i++){
        values.add(futures[i].get());
    }

    return values;
}