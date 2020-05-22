byte[] keyStart = Bytes.toBytes(1000);
byte[] keyEnd  = Bytes.toBytes(1000000);
byte[] columnMin = Bytes.toBytes(200);
byte[] columnMax = Bytes.toBytes(300);
byte[] cf = Bytes.toBytes(familyName)
byte[] column = Bytes.toBytes(columnNameToBeFiltered)

Scan scan = new Scan(keyStart, keyEnd);
FilterList list = new FilterList(FilterList.Operator.MUST_PASS_ALL);

SingleColumnValueFilter filter1 = new SingleColumnValueFilter(
cf, column, CompareOp.GREATER, columnMin);
list.add(filter1);

SingleColumnValueFilter filter2 = new SingleColumnValueFilter(
cf, column, CompareOp.LESS, columnMax);
list.add(filter2);
scan.setFilter(list);
ResultScanner scanner = table.getScanner(scan);
...//parsing result