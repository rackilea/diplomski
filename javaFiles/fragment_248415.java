// Find all `N`-item combinations consisting 1 item picked from 
// each of an `N` buckets
static <T> List<List<T>> pick1fromN(List<List<T>> s)
{
    List<List<T>> result = new ArrayList<>();
    int[] idx = new int[s.size()];
    while (idx[0] < s.get(0).size()) {
        List<T> pick = new ArrayList(s.size());
        for (int i = 0; i < idx.length; ++i) {
            pick.add(s.get(i).get(idx[i]));
        }
        result.add(pick);
        int i = idx.length - 1;
        while (++idx[i] >= s.get(i).size() && i > 0) {
            idx[i] = 0;
            --i;
        }
    }
    return result;
}