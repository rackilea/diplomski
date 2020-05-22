public static LinkedList<Data> merge(final LinkedList<Data> source) {
    final HashMap<Data, Integer> temp = new HashMap<>();

    for (final Data data : source) {
        final int count = data.getCount();
        data.setCount(0);
        if (temp.get(data) == null) {
            temp.put(data, count);
        }
        else {
            temp.put(data, temp.get(data) + count);
        }
    }

    final Set<Entry<Data, Integer>> set = temp.entrySet();
    final LinkedList<Data> result = new LinkedList<>();

    for (final Entry<Data, Integer> entry : set) {
        final Data mergedData = entry.getKey();
        mergedData.setCount(entry.getValue());
        result.add(mergedData);
    }

    Collections.sort(result, new DataComparator());

    return result;
}