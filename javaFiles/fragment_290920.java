public static <E> List<E> saveSublist(List<E> list, int fromIndex, int toIndex) {
    int checkedFromIndex = list.size() == 0
                           ? 0
                           : fromIndex >= list.size() ? list.size() - 1 : fromIndex;
    int checkedToIndex = toIndex > list.size() ? list.size() : toIndex;
    return list.subList(checkedFromIndex, checkedToIndex);
}