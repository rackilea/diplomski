Integer[] elements = new Integer[] { 4, 2, 7, 8, 1, 0, 3, 5, 9, 6 };

    List<Integer> arrayList = new ArrayList<>(Arrays.asList(elements));
    List<Integer> linkedList = new LinkedList<>(Arrays.asList(elements));

    for (int i = 0; i < elements.length; i++) { // Runs for O(n)
        Integer l1 = arrayList.get(i); // returns in O(1) 
        Integer l2 = linkedList.get(i); // returns in O(n)
    }