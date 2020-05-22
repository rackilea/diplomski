public <T> List<T> flattenListOfListsImperatively(
    List<List<T>> nestedList) {
    List<T> ls = new ArrayList<>();
    nestedList.forEach(ls::addAll);
    return ls;
}