public static <T> List<Future<T>> submitAll ( ExecutorService executor, Collection<? extends Callable<T> > tasks ) {
    List<Future<T>> result = new ArrayList<Future<T>>( tasks.size() );

    for ( Callable<T> task : tasks )
        result.add ( executor.submit ( task ) );

    return result;
}