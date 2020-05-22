public static <T> List<T> difference(
        List<? extends T> listA, List<? extends T> listB, Subtractor<T> subtractor) {
    int resultSize = Math.min(listA.size(), listB.size());
    List<T> result = new ArrayList<>(resultSize);
    for(int i=0; i<resultSize; ++i) {
        result.add(subtractor.subtract(listA.get(i), listB.get(i)));
    }
    return result;
}