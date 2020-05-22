// Find all 3-item combinations consisting of 1 item picked from
// each of 3 buckets 
static <T> List<List<T>> pick1From3(List<List<T>> in)
{
    List<List<T>> result = new ArrayList<>();
    for (int i = 0; i < in.get(0).size(); ++i) {
        for (int j = 0; j < in.get(1).size(); ++j) {
            for (int k = 0; k < in.get(2).size(); ++k)
                result.add(Arrays.asList(in.get(0).get(i), in.get(1).get(j), in.get(2).get(k)));
        }
    }
    return result;
}