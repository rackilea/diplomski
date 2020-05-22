List<List<Integer>> keys = new ArrayList<>(map.keySet());
Collections.sort(keys, new Comparator<List<Integer>>() {
    @Override public int compare(List<Integer> a, List<Integer> b) {
        // TODO handle edge cases, like lists of differing size

        for (int i=0; i<Math.min(a.size(), b.size()); i++) {
            int result = Integer.compare(a.get(i), b.get(i));
            if (result != 0) {
                return result;
            }
        }

        return 0;
    }
});

for (List<Integer> key : keys) {
    String value = map.get(key);
    // do something interesting with the value
}