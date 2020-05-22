public static <E> E[] toArray(List<E> list, Class<E> e) {
    @SuppressWarnings("unchecked")
    final E[] arr = (E[])Array.newInstance(e, list.size());

    return list.toArray(arr);
}