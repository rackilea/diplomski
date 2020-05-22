Table<String, String, Integer> table = HashBasedTable.create();
table.put("AS", "X", 2);
// with null check
table.put("AS", "BS", Objects.firstNonNull(table.get("AS", "BS"), 0) + 123);
System.out.println(table);
// prints: {AS={BS=123, X=2}}