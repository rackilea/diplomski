static Callable<?> wrap(Runnable r) {
    return () -> {
        r.run();
        return null;
    };
}
// ...
Performance.measureExecTime(wrap(() -> myMethod(myMethodParam1, myMethodParam2)), "gid", "database_qualifier");