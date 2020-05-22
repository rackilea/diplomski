HTable hTable = new HTable(hConn.config, "contribute");
        Scan scan = new Scan();
        scan.addColumn(Bytes.toBytes("book"), Bytes.toBytes("author"));
        scan.addColumn(Bytes.toBytes("book"), Bytes.toBytes("name"));
        ResultScanner scanner = hTable.getScanner(scan);

for (Result rr = scan.next() ; rr != null; rr = scan.next())  { 
NavigableMap familyMap = rr.getFamilyMap(Bytes.toBytes("book")); 
byte[] name = (byte[]) familyMap.get(Bytes.toBytes("name")); 
System.out.println(Bytes.toString(name)); // This you can assign it to variable
}