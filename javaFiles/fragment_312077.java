.stream()
   .collect(groupingBy(
       r -> r.getValue(COLUMNS.TABLE_NAME),
       LinkedHashMap::new,
       mapping(
           r -> new Column(
               r.getValue(COLUMNS.COLUMN_NAME),
               r.getValue(COLUMNS.TYPE_NAME)
           ),
           toList()
       )
   ))
   .forEach(
       (table, columns) -> {
            System.out.println(
                "CREATE TABLE " + table + " (");

            System.out.println(
                columns.stream()
                       .map(col -> "  " + col.name +
                                    " " + col.type)
                       .collect(Collectors.joining(",\n"))
            );

           System.out.println(");");
       }
  );