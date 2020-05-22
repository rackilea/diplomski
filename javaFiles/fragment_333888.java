Collections.sort(count.entrySet(), new Comparator<Entry<String, Integer>>() {
    @Override
    public int compare(Entry<String, Integer> x, Entry<String, Integer> y) {
        return x.getValue() - y.getValue();
    }
});