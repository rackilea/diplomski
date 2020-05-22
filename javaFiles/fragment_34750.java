TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
sorter.setComparator(0, new Comparator<Object>() {

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
});
table.setRowSorter(sorter);