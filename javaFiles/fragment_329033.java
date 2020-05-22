final int[] arr = new int[] { 9, 9, 8, 8, 1, 1, 2, 2, 2, 2, 3, 4, 5, 6, 7, 8 };
    Set<Integer> set = new HashSet<>();
    for (final int i : arr) {
        // makes use of Integer's hashCode() and equals()
        set.add(Integer.valueOf(i));
    }
    // priomitive int array without zeros
    final int[] newIntArray = new int[set.size()];
    int counter = 0;
    // SetUtils.orderedSet(set) requires apache commons collections
    set = SetUtils.orderedSet(set);
    final Iterator<Integer> iterator = set.iterator();
    while (iterator.hasNext()) {
        newIntArray[counter] = iterator.next().intValue();
        counter++;
    }
    for (final int i : newIntArray) {
        System.out.println(i);
    }