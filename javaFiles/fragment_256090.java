List<Integer> list = ...;
for (int index = 0; index < list.size(); index++) {
    final Integer val = list.get(index);
    // did you want to add something once you reach an index
    // or was it once you find a particular value?  
    if (index == 3) {
        // to insert after the current index
        list.add(index + 1, 6);
        // to insert at the end of the list
        // list.add(6);
    }
    System.out.println(val);
}