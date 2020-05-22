private void searchTable(final String query) {

    RowFilter<TableModel, Integer> filter = null;

    if (query.length() > 0) {
        filter = new RowFilter<TableModel, Integer>() {
            @Override
            public boolean include(RowFilter.Entry<? extends TableModel, ? extends Integer> entry) {

               for (int i = 0; i < entry.getValueCount(); i++) {
                   String stringValue = entry.getStringValue(i);
                   Object entryValue = entry.getValue(i);
                   String numberString = entryValue instanceof Long 
                                       ? String.valueOf(entryValue)
                                       : "";

                   if (stringValue.contains(query) || numberString.contains(query)) {
                       return true;
                   }
               }

               return false;
            }

        };
    }

    table.setRowFilter(filter);
}