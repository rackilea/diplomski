/**
 * Applies a function to a resource and closes it afterwards.
 * @param sup Supplier of the resource that should be closed
 * @param op operation that should be performed on the resource before it is closed
 * @return The result of calling op.apply on the resource 
 */
public static <A extends AutoCloseable, B> B applyAndClose(Callable<A> sup, Function<A, B> op) {
    try (A res = sup.call()) {
        return op.apply(res);
    } catch (RuntimeException exc) {
        throw exc;
    } catch (Exception exc) {
        throw new RuntimeException("Wrapped in applyAndClose", exc);
    }
}