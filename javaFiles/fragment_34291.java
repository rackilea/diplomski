public static <T> List<T> reverse(List <T> input) {
    ListIterator<T> iterator = input.listIterator(input.size());
    List<T> reversedList = new ArrayList<>(input.size());
    while (iterator.hasPrevious()) {
        T temp = iterator.previous();
        reversedList.add(temp);
    }
    return reversedList;
}