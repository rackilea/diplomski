/**
 * Construct a left value of either.
 * @param a The value underlying the either.
 * @return A left value of either.
 */
public static <B> MyEither<B> left(final String a) {
    return new MyLeft<B>(a);
}