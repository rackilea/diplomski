public static <T extends BaseType> boolean areFieldsEqual(T left, T right, Function<T,? extends Comparable>... fields)
{
    if (fields.length < 1) {
        return true;
    }
    Comparator<T> c = Comparator.comparing(fields[0]);
    for (int i = 1; i < fields.length; i++) {
        c = c.thenComparing (fields[i]);
    }
    return c.compare(left, right) == 0;
}