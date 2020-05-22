Collections.sort(column, new Comparator<Minterm>() {
    @Override
    public int compare(Minterm o1, Minterm o2) {
        return Integer.valueOf(o1.groupNo).compareTo(o2.groupNo);
    }
});