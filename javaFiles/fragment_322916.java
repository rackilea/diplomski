public interface List<T> {
    /** snip */
}

public class Arrays {
    private static class ArrayList<T> implements List<T> {
        /** snip */
    }

    public <T> List<T> asList(T... arr) {
        return new ArrayList<>(arr);
    }
}