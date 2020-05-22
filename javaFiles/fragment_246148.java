public void fixedPoint(ArrayList<Integer> list1, ArrayList<Integer> list2)
{
    boolean isAscending = true;
    for (int i = 1 ; (isAscending) && (i < list2.size()) ; i++) {
        isAscending = list2.get(i-1) < list2.get(i);
    }
    if (isAscending) {
        ... // Insert code to copy the data from list2 to list1.
        ... // Note that a simple assignment is not going to work here!
        System.out.println("found!!!");
        return;
    }
    // It's not in ascending order - continue recursing down.
    ascending(list2, list1);
    ArrayList<Integer> temp1 = new ArrayList<Integer>(list1); // store processed value
    fixedPoint(list2, list1);
    // temp1 makes the old value of list1 available for comparison
    System.out.println("st list1 is "+list1);
    System.out.println("st list1 was "+temp1);
    System.out.println("st list2 is "+list2);
}