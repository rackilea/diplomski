class CustomClass {
    private Function<Integer,Integer> cal;

    public CustomClass (Function<Integer,Integer>... func) {
        cal =  Stream.of(func)
                .reduce(Function.identity(), Function::andThen);
    }
}