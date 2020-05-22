public List<Integer> merge (List<Integer> l1, List<Integer> l2) {
    List<Integer> result = new ArrayList<>();
    int i1 = 0, i2 = 0;
    while (i1 < l1.size() && i2 < l2.size())
        if (l1.get(i1) < l2.get(i2))
            result.add (l1.get(i1++));
        else
            result.add (l2.get(i2++));
    while (i1 < l1.size())
        result.add (l1.get(i1++));
    while (i2 < l2.size())
        result.add (l2.get(i2++));
    return result;
}