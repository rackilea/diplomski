// Find all `N * k`-item combinations formed by picking `k` items
// from each of `N` buckets
static <T> List<List<T>> pickKfromEach(List<List<T>> sets, int k)
{
    List<List<List<T>>> kCombos = new ArrayList<>(sets.size());
    for (List<T> ms : sets) {
        kCombos.add(combinations(ms, k));
    }
    ArrayList<List<T>> result = new ArrayList<>();
    int[] indices = new int[kCombos.size()];
    while (indices[0] < kCombos.get(0).size()) {
        List<T> pick = new ArrayList<>(kCombos.size());
        for (int i = 0; i < indices.length; ++i) {
            pick.addAll(kCombos.get(i).get(indices[i]));
        }
        result.add(pick);
        int i = indices.length - 1;
        while (++indices[i] >= kCombos.get(i).size() && i > 0) {
            indices[i] = 0;
            --i;
        }
    }
    return result;
}

static <T> List<List<T>> combinations(List<T> s, int k) throws IllegalArgumentException
{
    if (k < 0 || k > s.size()) {
        throw new IllegalArgumentException("Can't pick " + k
            + " from set of size " + s.size());
    }
    List<List<T>> res = new LinkedList<>();
    if (k > 0) {
        int idx[] = new int[k];
        for (int ix = 0; ix < idx.length; ++ix) {
            idx[ix] = ix;
        }
        while (idx[0] <= s.size() - k) {
            List<T> combo = new ArrayList<>(k);
            for (int ix = 0; ix < idx.length; ++ix) {
                combo.add(s.get(idx[ix]));
            }
            res.add(combo);
            int ix = idx.length - 1;
            while (ix > 0 && (idx[ix] == s.size() - k + ix))
               --ix;
            ++idx[ix];
            while (++ix < idx.length)
                idx[ix] = idx[ix-1]+1;
        }
    }
    return res;
}