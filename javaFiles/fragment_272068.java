List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(3);
String selected = "Nissan SUV";
filters.add(RowFilter.regexFilter("(?i)" + selected)); // added the string filter
filters.add(RowFilter.dateFilter(RowFilter.ComparisonType.AFTER, startDate));
filters.add(RowFilter.dateFilter(RowFilter.ComparisonType.BEFORE, endDate));
RowFilter<Object, Object> rf = RowFilter.andFilter(filters);
rowSorter.setRowFilter(rf);