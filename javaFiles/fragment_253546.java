class ParallelSender{

    private final Map<Callable<?>, Object> map =
        new HashMap<Callable<?>, Object>();

    @SuppressWarnings("unchecked")
    public <T> T getResult(final Callable<T> callable){
        return (T) map.get(callable);
    }

}