HashSet<Set<Set<List<Integer>>>> Sa = new HashSet<>();

    // Creating dummy data

    // Two List of Integers
    List<Integer> listInt1 = new ArrayList<>();
    List<Integer> listInt2 = new ArrayList<>();

    // Populating the list
    for (int i = 0; i < 4; i++) {
        listInt1.add(i);
        listInt2.add(i+30);
    }

    // Data structure of Sa.
    Set<List<Integer>> setOfIntLists1 = new HashSet<>();
    Set<List<Integer>> setOfIntLists2 = new HashSet<>();

    setOfIntLists1.add(listInt1);
    setOfIntLists1.add(listInt2);

    setOfIntLists2.add(listInt2);
    setOfIntLists2.add(listInt1);

    Set<Set<List<Integer>>> setOfset1 = new HashSet<>();
    Set<Set<List<Integer>>> setOfset2 = new HashSet<>();

    setOfset1.add(setOfIntLists1);
    setOfset1.add(setOfIntLists2);

    setOfset2.add(setOfIntLists2);
    setOfset2.add(setOfIntLists1);

    // Adding data to Sa
    Sa.add(setOfset1);
    Sa.add(setOfset2);

    for (Set<Set<List<Integer>>> aSa : Sa) {
        for (Set<List<Integer>> bSa : aSa) {

            Iterator<List<Integer>> iter = bSa.iterator();

            while(iter.hasNext()) {
                System.out.println(iter.next());
            }
        }
    }
}