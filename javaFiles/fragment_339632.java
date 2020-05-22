public List<Integer> mergeThem(List<Integer> left, List<Integer> right) {
    //set the sorted list
    List<Integer> sortedList = new ArrayList<Integer>();
    //getting the iterators for both lists because List#get(x) can be O(N) on LinkedList
    Iterator<Integer> itLeft = left.iterator();
    Iterator<Integer> itRight = right.iterator();
    //getting flags in order to understand if the iterator moved
    boolean leftChange = true, rightChange = true;
    //getting the current element in each list
    Integer leftElement = null, rightElement = null;
    //while there are elements in both lists
    //this while loop will stop when one of the list will be fully read
    //so the elements in the other list (let's call it X) must be inserted
    while (itLeft.hasNext() && itRight.hasNext()) {
        //if left list element was added to sortedList, its iterator must advance one step
        if (leftChange) {
            leftElement = itLeft.next();
        }
        //if right list element was added to sortedList, its iterator must advance one step
        if (rightChange) {
            rightElement = itRight.next();
        }
        //cleaning the change flags
        leftChange = false;
        rightChange = false;
        //doing the comparison in order to know which element will be inserted in sortedList
        if (leftElement <= rightElement) {
            //if leftElement is added, activate its flag
            leftChange = true;
            sortedList.add(leftElement);
        } else {
            rightChange = true;
            sortedList.add(rightElement);
        }
    }
    //this is the hardest part to understand of this implementation
    //java.util.Iterator#next gives the current element and advance the iterator on one step
    //if you do itLeft.next then you lost an element of the list, that's why we have leftElement to keep the track of the current element of left list (similar for right list)
    if (leftChange && rightElement != null) {
        sortedList.add(rightElement);
    }
    if (rightChange && leftElement != null) {
        sortedList.add(leftElement);
    }
    //in the end, you should add the elements of the X list (see last while comments).
    while (itLeft.hasNext()) {
        sortedList.add(itLeft.next());
    }
    while (itRight.hasNext()) {
        sortedList.add(itRight.next());
    }
    return sortedList;
}