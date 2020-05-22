public static Set<List<Integer>> orderings(int i, int len, int max) {

    Set<List<Integer>> seqs = new HashSet<List<Integer>>();

    if (len <= 0 || i > max)
        return seqs;

    if (max - i == len) {
        List<Integer> l = new ArrayList<Integer>();
        while (i < max)
            l.add(i++);
        seqs.add(l);
        return seqs;
    }

    seqs.addAll(orderings(i    , len - 1, max));
    seqs.addAll(orderings(i + 1, len - 1, max));

    for (List<Integer> l : seqs)
        l.add(0, i);

    return seqs;
}


public static Set<List<Integer>> orderings(int[] arr1, int[] arr2) {
    return orderings(0, arr2.length, arr1.length);
}