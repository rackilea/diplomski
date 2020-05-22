public class Blah {
    private final Collection<Integer> collection;

    public Blah(Collection<Integer> collection) {
        this.collection = clone(collection);
    }

    @SuppressWarnings("unchecked")
    private static <T> T clone(T t) {
        try {
            Method cloneMethod = t.getClass().getDeclaredMethod("clone");
            return (T) cloneMethod.invoke(t);
        } catch (Exception ex) {
            // TODO Log ex
            return null;
        }
    }
}