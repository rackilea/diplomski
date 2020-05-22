NavigableSet<Integer> min3 = new TreeSet<Integer>();
    //We keep only 3 elements in min3, as soon as the set size grows over 3
    //we remove the last element, which is the max.

    for (int x : array) {
        min3.add(x);
        if (min3.size() > 3) {
            min3.pollLast();
        } 
    }

    if (array.length >= 3) {
        Integer thirdMinimum = min3.pollLast();
        System.out.println(thirdMimimum);
    } else {
       //array must contain at least 3 elements
    }