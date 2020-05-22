public static <A, T> Optional<T> tryOpt (Fn<A, T> f, A arg) {
    try {
        return Optional.of(f.apply(arg));
    } catch (Exception e) {
        System.out.println(e.getMessage());
        return Optional.empty();
    }
}


public static interface Fn<A, T> {
      T apply(A a) throws Exception;
}