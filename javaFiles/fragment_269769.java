Iterator iterator = arrayList.iterator();

    // total execution time: O(N)
    while (iterator.hasNext()) { // runs for each element iteratively
        System.out.print(iterator.next());
    }
    System.out.println();

    iterator = linkedList.iterator();

    // total execution time: O(N)
    while (iterator.hasNext()) { // runs for each element iteratively
        System.out.print(iterator.next());
    }
    System.out.println();