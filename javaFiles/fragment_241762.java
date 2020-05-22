/**
 * @param input The unsorted list
 * @return a new List with the sorted elements
 */
public static List<Integer> returnSortedList(List<Integer> input) {
    List<Integer> sortedList = new ArrayList<>(input);
    sortedList.sort(new CustomComparator());
    return sortedList;
}