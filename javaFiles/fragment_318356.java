@SuppressWarnings("unchecked")
public static final List EMPTY_LIST = new EmptyList<>();
// ...

@SuppressWarnings("unchecked")
public static final <T> List<T> emptyList() {
    return (List<T>) EMPTY_LIST;
}