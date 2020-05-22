/**
 * Construct a left value of either.
 * @param a The value underlying the either.
 * @return A left value of either.
 */
public static <A, B> Either<A, B> left(final A a) {
    return new Left<A, B>(a);
}