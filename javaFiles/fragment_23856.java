public static List<Integer> alternate(List<Integer> list1, List<Integer> list2) {
    List<Integer> template = new LinkedList<>();

    // Add elements alternately from each of the input lists.
    Iterator<Integer> it1 = list1.iterator();
    Iterator<Integer> it2 = list2.iterator();

    while (it1.hasNext() && it2.hasNext()) {
        template.add(it1.next());
        template.add(it2.next());
    }

    // Add the extra elements from whichever list has not reached the end.
    while (it1.hasNext()) {
        template.add(it1.next());
    }
    while (it2.hasNext()) {
        template.add(it2.next());
    }

    return template;
}