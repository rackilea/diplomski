// Find all 2-item combinations consisting of 1 item picked from 
// each of 2 buckets
static <T> List<List<T>> pick1From2(List<List<T>> in)
{
    List<List<T>> result = new ArrayList<>();
    for (int i = 0; i < in.get(0).size(); ++i) {
        for (int j = 0; j < in.get(1).size(); ++j) {
            result.add(Arrays.asList(in.get(0).get(i), in.get(1).get(j)));
        }
    }
    return result;
}