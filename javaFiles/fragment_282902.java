static <T> Function<T,Callable<Object>> toCallable() {
    return n -> () -> {
        System.out.println(n); 
        return null;
    };
}