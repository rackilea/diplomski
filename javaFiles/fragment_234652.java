static <T> Predicate<T> logging(Predicate<T> p, BiConsumer<T,Boolean> log, boolean all) {
    return t -> {
        final boolean result = p.test(t);
        if(all || result) log.accept(t, result);
        return result;
    };
}