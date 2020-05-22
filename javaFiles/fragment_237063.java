class CustomClass {
    private Function<Map<String, String>, Map<String, String>> cal;

    public CustomClass (Function<Map<String, String>, Map<String, String>>... func) {
        cal =  Stream.of(func)
                .reduce(Function.identity(), Function::andThen);
    }
}