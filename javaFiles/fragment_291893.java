((TableSortController)table.getRowSorter()).setComparator(0, new Comparator<Float>() {
    @Override
    public int compare(Float o1, Float o2) {
        return o1.compareTo(o2);
    }
});