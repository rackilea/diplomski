Table origTable = persistentClass.getTable();
String schema = origTable.getSchema();
String catalog = origTable.getCatalog();
String name = origTable.getName();
mappings.addTable(schema, catalog, name, origTable.getSubselect(),
        origTable.isAbstract());
Table table = mappings.getTable(schema, catalog, name);
Iterator<Column> columnIter = origTable.getColumnIterator();
while (columnIter.hasNext()) {
    Column column = columnIter.next();
    table.addColumn(column);
}