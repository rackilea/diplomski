public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList(1, 2, 4, 6, 7, 8);
    List<Integer> list2 = Arrays.asList(1, 3, 4, 5, 6, 9);

    List<List<Integer>> listExtras = getExtraElementsOfLists(list1, list2);
    List<Integer> list1Extras = listExtras.get(0);
    List<Integer> list2Extras = listExtras.get(1);

    System.out.println("List 1 extras:");
    for (Integer i : list1Extras)
        System.out.println(i);

    System.out.println();
    System.out.println("List 2 extras:");
    for (Integer i : list2Extras)
        System.out.println(i);
}


public static <T extends Comparable<T>> List<List<T>> getExtraElementsOfLists(List<T> list1,
        List<T> list2) {
    Collections.sort(list1);
    Collections.sort(list2);

    List<T> list1Extras = new ArrayList<>();
    List<T> list2Extras = new ArrayList<>();
    int index1 = 0;
    int index2 = 0;
    while (index1 < list1.size() && index2 < list2.size()) {
        T value1 = list1.get(index1);
        T value2 = list2.get(index2);
        int delta = value1.compareTo(value2);
        if (delta < 0) { // val1 < val2, list2 !contain val1
            list1Extras.add(value1);
            index1++;
        } else if (delta > 0) { // val1 > val2, list1 !contain val2
            list2Extras.add(value2);
            index2++;
        } else { // both have the same value
            index1++;
            index2++;
        }
    }
    // whichever list still has elements, add them all to its extras
    for (; index1 < list1.size(); index1++)
        list1Extras.add(list1.get(index1));
    for (; index2 < list2.size(); index2++)
        list2Extras.add(list2.get(index2));

    return Arrays.asList(list1Extras, list2Extras);
}