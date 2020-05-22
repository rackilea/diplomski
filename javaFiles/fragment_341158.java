Composite start = new Composite();
start.addComponent(0, "A", Composite.ComponentEquality.EQUAL);
start.addComponent(1, "A", Composite.ComponentEquality.EQUAL);
start.addComponent(2, "A", Composite.ComponentEquality.EQUAL);

Composite end = new Composite();
end.addComponent(0, "B", Composite.ComponentEquality.EQUAL);
end.addComponent(1, "B", Composite.ComponentEquality.EQUAL);
end.addComponent(2, "B", Composite.ComponentEquality.GREATER_THAN_EQUAL);

SliceQuery<String, Composite, String> sliceQuery = HFactory.createSliceQuery(keyspace, se, ce, se);
sliceQuery.setColumnFamily("CF").setKey(myKey);
ColumnSliceIterator<String, Composite, String> csIterator = new ColumnSliceIterator<String, Composite, String>(sliceQuery, start, end, false);

while (csIterator.hasNext()) ....