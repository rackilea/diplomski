public <E> void sortBy(final String fieldName, final boolean sortAsc, List<E> list) throws NoSuchMethodException {
    final Method f = list.get(0).getClass().getMethod(fieldName.replace("SortBy", "get"));
    f.setAccessible(true);
    final int direction = sortAsc ? +1 : -1;
    Collections.sort(list, new Comparator<E>() {
        public int compare(E o1, E o2) {
            return compareFields(o1, o2, f, direction);
        }
    }
    );
}

@SuppressWarnings({"rawtypes", "unchecked"})
protected <E> int compareFields(E o1, E o2, Method getter, int sortAsc) {
    try {
        Comparable o1Data = (Comparable) getter.invoke(o1);
        Comparable o2Data = (Comparable) getter.invoke(o2);
        if (o1Data == null)
            return o2Data == null ? 0 : 1;
        if (o2Data == null)
            return -1;
        return sortAsc * o2Data.compareTo(o1Data);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}