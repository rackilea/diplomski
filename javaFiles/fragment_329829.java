private <T> int getObjectIndexFromList(List<T> list, Predicate<T> predicate){
    int index;
    try {
        index = list.indexOf(list.stream()
                .filter(predicate)
                .findFirst()
                .get());
    } catch (NoSuchElementException ex){
        index = -1;
    }
    return index;
}