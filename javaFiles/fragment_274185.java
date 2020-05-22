Long start, end;
start = System.currentTimeMillis();

Scan s = new Scan(String.valueOf(80000).getBytes(), String.valueOf(80100).getBytes());
s.setCaching(100);
s.addColumn("Subject".getBytes(), "History".getBytes());

ResultScanner scanner = table.getScanner(s);
try {
    for (Result rr = scanner.next(); rr != null; rr=scanner.next()) {
        System.out.println("Found row: " + new String(rr.getRow(), "UTF-8") + " value: " + new String(rr.getValue("Subject".getBytes(), "History".getBytes()), "UTF-8")));
    }
    end = System.currentTimeMillis(); 
} finally {
    scanner.close();
}       
System.out.println("Scan: " + (end - start));