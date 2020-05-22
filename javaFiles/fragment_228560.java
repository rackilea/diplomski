private List<List<T>> getCombination(int currentIndex, List<TempContainer<T>> containers) {
    if (currentIndex == containers.size()) {
        // Skip the items for the last container
        List<List<T>> combinations = new ArrayList<List<T>>();
        combinations.add(new ArrayList<T>());
        return combinations;
    }
    List<List<T>> combinations = new ArrayList<List<T>>();
    TempContainer<T> container = containers.get(currentIndex);
    List<T> containerItemList = container.getItems();
    // Get combination from next index
    List<List<T>> suffixList = getCombination(currentIndex + 1, containers);
    int size = containerItemList.size();
    for (int ii = 0; ii < size; ii++) {
        T containerItem = containerItemList.get(ii);
        if (suffixList != null) {
            for (List<T> suffix : suffixList) {
                List<T> nextCombination = new ArrayList<T>();
                nextCombination.add(containerItem);
                nextCombination.addAll(suffix);
                combinations.add(nextCombination);
            }
        }
    }
    return combinations;
}