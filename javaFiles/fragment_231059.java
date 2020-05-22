// A "size()" comparator 
private static Comparator<LinkedList<Long>> comp = new Comparator<LinkedList<Long>>() {
    @Override
    public int compare(LinkedList<Long> o1, LinkedList<Long> o2) {
        return new Integer((o1 == null) ? 0 : o1.size()).compareTo((o2 == null) ? 0 : o2.size());
    }
};
public static void main(String[] args) {
    // LinkedList<LinkedList<Long>>() overalllList = new LinkedList<LinkedList<Long>();
    // Note there is an extra () to the left of your overalllList.
    LinkedList<LinkedList<Long>> overalllList = new LinkedList<LinkedList<Long>>();
    LinkedList<Long> list3 = new LinkedList<Long>();
    LinkedList<Long> list2 = new LinkedList<Long>();
    LinkedList<Long> list1 = new LinkedList<Long>();

    for (long i = 0; i < 5; i++) { // 5, or 1000
        if (i < 2) {
            list1.add(i);
        }
        if (i < 3) { // 3, or 245.
            list2.add(i);
        }
        list3.add(i);
    }
    overalllList.add(list3);
    overalllList.add(list2);
    overalllList.add(list1);
    System.out.println("Before: " + overalllList);

    Collections.sort(overalllList, comp);
    System.out.println("After: " + overalllList);
}