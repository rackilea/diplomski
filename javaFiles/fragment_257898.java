private static <T> List<List<T>> splitBySeparator(List<T> list, Predicate<? super T> predicate) {
    final List<List<T>> finalList = new ArrayList<>();
    int fromIndex = 0;
    int toIndex = 0;
    for(T elem : list) {
        if(predicate.test(elem)) {
            finalList.add(list.subList(fromIndex, toIndex));
            fromIndex = toIndex + 1;
        }
        toIndex++;
    }
    if(fromIndex != toIndex) {
        finalList.add(list.subList(fromIndex, toIndex));
    }
    return finalList;
}