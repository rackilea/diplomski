public void run() {
    int SLICE = 729;
    List<List<Integer>> list2d = new ArrayList<List<Integer>>();
    // fill original list
    List<List<List<Integer>>> list3d = new ArrayList<List<List<Integer>>>();
    List<List<Integer>> partial = new ArrayList<List<Integer>>(SLICE);
    for (List<Integer> list : list2d) {
        partial.add(list);
        if (partial.size() == SLICE) {
            list3d.add(partial);
            partial = new ArrayList<List<Integer>>(SLICE);
        }
    }
    if (!partial.isEmpty()) {
        list3d.add(partial);
    }
}