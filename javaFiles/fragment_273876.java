final class LispList<E> {
    private final E           head;
    private final LispList<E> tail;
    private LispList(E head, LispList<E> tail) {
        this.head = head;
        this.tail = tail;
    }

    /** returns the first item of the list it is called on */
    public E head() {
        if (isEmpty()) throw new IllegalStateException();
        return this.head;
    }
    /** returns a new list consisting of all but the first item of the list it is called on */
    public LispList<E> tail() {
        if (isEmpty()) throw new IllegalStateException();
        return this.tail;
    }
    /** takes an argument and returns a new list whose head is the argument and whose tail is the list it is called on */
    public LispList<E> cons(E item) {
        return new LispList<>(item, this);
    }
    /** returns true if the list it is called on is the empty list, returns false otherwise */
    public boolean isEmpty() {
        return this.tail == null;
    }
    /** returns an empty list */
    public static <T> LispList<T> empty() {
        return new LispList<>(null, null);
    }

    @SafeVarargs
    public static <T> LispList<T> of(T ... values) {
        LispList<T> ls = empty();
        for (int i = values.length - 1; i >= 0; i--)
            ls = ls.cons(values[i]);
        return ls;
    }
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (LispList<E> ls = this; ! ls.isEmpty(); ls = ls.tail())
            joiner.add(String.valueOf(ls.head()));
        return joiner.toString();
    }
}