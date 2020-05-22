private int[] withoutDuplicates(int[] a){
    Set<Integer> set = new LinkedHashSet<Integer>();
    for (int x : a) {
        set.add(x);
    }
    int[] newArray = new int[set.size()];
    int ii = 0;
    for (Integer x : set) {
        newArray[ii++] = x;
    }
    return newArray;
}