Map<String, Row> rowMap = new HashMap<>();
Map<String, Row> rowMap = new TreeMap<>(); // Sorted
Map<String, Row> rowMap = new LinkHashMap<>(); // In order of insertion, chronological

String rowId = "A";
rowMap.put(rowId, row);
Row row = rowMap.get(rowId);