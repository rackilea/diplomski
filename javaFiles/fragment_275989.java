public <T> List<List<T>> zip(List<T> ... lists) {

    if(lists.isEmpty()) {
        return Collections.<List<T>>emptyList();
    }

    // validate that the input lists are all the same size.
    int numItems = lists[0].size();
    for(int i = 1; i < lists.length; i++) {
        if(lists[i].size() != numItems) {
            throw new IllegalArgumentException("non-uniform-length list at index " + i);
        }
    } 

    List<List<T>> result = new ArrayList<List<T>>();

    for(int i = 0; i < numItems; i++) {

        // create a tuple of the i-th entries of each list
        List<T> tuple = new ArrayList<T>(lists.length);
        for(List<T> list : lists) {
            tuple.add(list.get(i));
        }

        // add the tuple to the result
        result.add(tuple);
    }

    return result;
}