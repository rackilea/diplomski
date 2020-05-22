public static <T> T findByString(T[] values, String toString) {
    Objects.requireNonNull(toString);
    for (T t : values) {
        if (toString.equals(t.toString())) {
            return t;
        }
    }
    throw new IllegalArgumentException();
}