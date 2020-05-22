final int elementsPerGroup = 3;

// your init list
List<Integer> list = Arrays.asList(1, 2, 3, 1, 4, 7, 1, 5, 9);

// the final list of lists
List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();

// logic
for (int i = 0; i < list.size(); i++) {
    List<Integer> sublist;
    if (i % elementsPerGroup == 0) {
        sublist = new ArrayList<Integer>();
        listOfLists.add(sublist);
    } else {
        sublist = listOfLists.get(listOfLists.size() - 1);
    }
    sublist.add(list.get(i));
}