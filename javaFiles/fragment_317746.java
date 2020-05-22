Filter filter = new FilterList(FilterList.Operator.MUST_PASS_ONE);
known_fields.forEach(known_field -> 
      filter.addFilter(new ColumnRangeFilter(known_field.getBytes(), true, 
                                             known_field.getBytes(), true));
filter.add(new ColumnRangeFilter(start, true, stop, true));
scan.setFilter(filter);