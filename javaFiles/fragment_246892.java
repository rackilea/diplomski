public static <T> List<List<T>> split(List<T> list, int size)
        throws NullPointerException, IllegalArgumentException {
    if (list == null) {
        throw new NullPointerException("The list parameter is null.");
    }

    if (size <= 0) {
        throw new IllegalArgumentException(
                "The size parameter must be more than 0.");
    }

    List<List<T>> result = new ArrayList<List<T>>(size);

    for (int i = 0; i < size; i++) {
        result.add(new ArrayList<T>());
    }

    int index = 0;

    for (T t : list) {
        result.get(index).add(t);
        index = (index + 1) % size;
    }

    return result;
}