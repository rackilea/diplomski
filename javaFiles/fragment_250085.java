ArrayList<RowFilter<Object, Object>> andFilters = new ArrayList<RowFilter<Object, Object>>();
andFilters.add(candyFilter);
andFilters.add(colorFilter);

sorter = new TableRowSorter<TableModel>(myTable.getModel());

// Mentos and M&Ms that are red or blue
sorter.setRowFilter(RowFilter.andFilter(andFilters));

myTable.setRowSorter(sorter);