List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(3);
filters.add(getStringFilter());
filters.add(getStartDateFilter());
filters.add(getEndDateFilter();
RowFilter<Object, Object> rf = RowFilter.andFilter(filters);
rowSorter.setRowFilter(rf);