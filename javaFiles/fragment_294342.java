/**
 * An EPredicate is a Predicate that allows a checked exception to be thrown.
 *
 * @param <T> the type of the input to the predicate
 * @param <E> the allowed exception
 */
@FunctionalInterface
public interface EPredicate<T, E extends Exception> {

    /**
     * (1) the method permits a checked exception
     */
    boolean test(T t) throws E;

    /**
     * (2) the method adapts an EPredicate to a Predicate.
     */
    static <T, E extends Exception> Predicate<T> unwrap(EPredicate<T, E> predicate) {
        return t -> {
            try {
                return predicate.test(t);
            } catch (Exception e) {
                return false;
            }
        };
    }

}