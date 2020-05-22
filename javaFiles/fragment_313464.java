@FunctionalInterface
interface ThrowingFunction<T, R, E extends Exception>
{
    R apply(T t) throws E;

    /**
     * Composes f (after) and g (before) to produce the composed
     * function f o g(v), which executes f(g(v)).
     * @param f The function that will take g's output <T> as input to return the overall result <R>.
     * @param g The function that will take the overall input <V> and return f's input <T>.
     * @param <V> The input result type of the entire composed function (and of function g).
     * @param <T> The result type of g, used as input to f.
     * @param <R> The end result type of the entire composed function (and of function f).
     * @param <S> If any of f or g throws an exception, it is captured by the supertype exception class S.
     * @param <E1> The exception type thrown by f.
     * @param <E2> The exception type thrown by g.
     * @return A ThrowingFunction that whose input <V> is applied to g, whose result is passed to
     *     f to generate the overall result <R>.
     */
    static <V, T, R, S extends Exception, E1 extends S, E2 extends S> ThrowingFunction<V, R, S>
        compose(ThrowingFunction<? super T, ? extends R, ? extends E1> f,
                ThrowingFunction<? super V, ? extends T, ? extends E2> g)
    {
        return v -> f.apply(g.apply(v));
    }
}