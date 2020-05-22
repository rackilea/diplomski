SliceQuery<String, Composite, String> sliceQuery = HFactory.createSliceQuery(keyspace, StringSerializer.get(), CompositeSerializer.get(), StringSerializer.get());
sliceQuery.setColumnFamily("test");
sliceQuery.setKey("key1");
sliceQuery.setRange(null, null, false, Integer.MAX_VALUE);
QueryResult<ColumnSlice<Composite, String>> result = sliceQuery.execute();
ColumnSlice<Composite, String> slice = result.get();

List<HColumn<Composite, String>> columns = slice.getColumns();

System.out.println("Packed");
System.out.println(columns);

System.out.println();
System.out.println("Unpacked");
for (HColumn<Composite, String> column : columns) {
  String first = column.getName().get(0, StringSerializer.get());
  String second = column.getName().get(1, StringSerializer.get());
  System.out.println(first + ":" + second + "=" + column.getValue());
}