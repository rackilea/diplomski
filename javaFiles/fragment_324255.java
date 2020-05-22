TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
//Comparator<MyData> c = Comparator.comparing(MyData::getName);
//sorter.setComparator(0, c);
//sorter.setComparator(1, c.thenComparing(Comparator.comparingInt(MyData::getDuration)));
//sorter.setComparator(2, c.thenComparing(Comparator.comparing(MyData::getBook)));
sorter.setComparator(0, new MyDataGroupComparator(0));
sorter.setComparator(1, new MyDataGroupComparator(1));
sorter.setComparator(2, new MyDataGroupComparator(2));
table.setRowSorter(sorter);