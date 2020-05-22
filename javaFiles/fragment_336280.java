/**
 * Performs operations upon an input object which may modify that object and/or
 * external state (other objects).
 *
 * <p>All block implementations are expected to:
 * <ul>
 * <li>When used for aggregate operations upon many elements blocks
 * should not assume that the {@code apply} operation will be called upon
 * elements in any specific order.</li>
 * </ul>
 *
 * @param <T> The type of input objects to {@code apply}.
 */
public interface Block<T> {
/**
 * Performs operations upon the provided object which may modify that object
 * and/or external state.
 *
 * @param t an input object
 */
void apply(T t);

// Some extension methods that I'll have to do with below.
}