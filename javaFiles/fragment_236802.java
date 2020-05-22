public boolean contains(int x, ArrayList<ArrayList<Integer>> listOfLists) {
    for (ArrayList list: listOfLists) {
        if (list.contains(x)) return true;
    }
    return false;
}