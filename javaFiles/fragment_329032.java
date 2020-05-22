final int[] arr = new int[] { 1, 1, 2, 2, 2, 2, 3, 4, 5, 6, 7, 8 };
    final Set<Integer> set = new HashSet<>();
    for (final int i : arr) {
        // makes use of Integer's hashCode() and equals()
        set.add(Integer.valueOf(i));
    }
    // primitive int array without zeros
    final int[] newIntArray = new int[set.size()];
    int counter = 0;
    final Iterator<Integer> iterator = set.iterator();
    while (iterator.hasNext()) {
        newIntArray[counter] = iterator.next().intValue();
        counter++;
    }
    for (final int i : newIntArray) {
        System.out.println(i);
    }