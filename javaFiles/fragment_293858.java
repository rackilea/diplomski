public static <T> List<T> removeDuplicates(List<T> inputList) {
    // null uses natural ordering
    return removeDuplicates(inputList, null);
}

public static <T> List<T> removeDuplicates(List<T> inputList, Comparator<? super T> comparator) {
    Set<T> set = new TreeSet<>(comparator);
    set.addAll(inputList);
    return new ArrayList<>(set);
}

public static void main(String[] args) {
    System.out.println(removeDuplicates(Arrays.asList(1, 2, 2, 3)));
    System.out.println(removeDuplicates(Arrays.asList("a", "b", "B", "c"), String.CASE_INSENSITIVE_ORDER));
}