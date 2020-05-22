public static<T> ArrayList<ArrayList<T>> getPermutations (List<T> elements, int k) {
    return getPermutations (elements,k,0);
}

public static<T> ArrayList<ArrayList<T>> getPermutations (List<T> elements, int k, int i) {
    ArrayList<ArrayList<T>> results = new ArrayList<>();
    if(k > 0) {
        int n = elements.size();
        for(int j = i; j <= n-k; j++) {
            T val = elements.get(j);
            ArrayList<ArrayList<T>> tails = getPermutations(elements,k-1,j+1);
            for(ArrayList<T> tail : tails) {
                ArrayList<T> result = new ArrayList<>();
                result.add(val);
                result.addAll(tail);
                results.add(result);
            }
        }
    } else {
        results.add(new ArrayList<T>());
    }
    return results;
}