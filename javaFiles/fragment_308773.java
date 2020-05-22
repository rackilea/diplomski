public class B<E extends Cloneable> {
    E data;

    public B(E elem) {
        this.data = elem;
    }

    @SuppressWarnings("unchecked")
    public E get() {
        Method clone = null;
        try {
            clone = data.getClass().getMethod("clone");
            Object[] args = new Object[0];
            return (E) clone.invoke(data, args);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}