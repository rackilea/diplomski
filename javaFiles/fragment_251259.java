public static void main(String ... args) {
    Function<Number, char[]> func = 
       convert(o->o.toString(), o->o.toCharArray()).andThen(Function.identity());
}

public static <A, B, C> Function<A, C> convert(Function<A, B> c1, Function<B, C> c2) {
    return t -> c2.apply(c1.apply(t));
}