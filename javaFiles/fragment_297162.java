// Sometimes, you won't know the row you're looking for. In this case, you
// use a Scanner. This will give you cursor-like interface to the contents
// of the table.  To set up a Scanner, do like you did above making a Put
// and a Get, create a Scan.  Adorn it with column names, etc.
Scan s = new Scan();
s.addColumn(Bytes.toBytes("myLittleFamily"), Bytes.toBytes("someQualifier"));
ResultScanner scanner = table.getScanner(s);
try {
  // Scanners return Result instances.
  // Now, for the actual iteration. One way is to use a while loop like so:
  for (Result rr = scanner.next(); rr != null; rr = scanner.next()) {
    // print out the row we found and the columns we were looking for
    System.out.println("Found row: " + rr);
  }

  // The other approach is to use a foreach loop. Scanners are iterable!
  // for (Result rr : scanner) {
  //   System.out.println("Found row: " + rr);
  // }
} finally {
  // Make sure you close your scanners when you are done!
  // Thats why we have it inside a try/finally clause
  scanner.close();
}