Set<String> statuses = table.columnKeySet();
System.out.print("Height");
for (String status : statuses) {
  System.out.print("|" + status);
}
System.out.println();
for (Long height : table.rowKeySet()) {
  System.out.print(height);
  for (String status : statuses) {
    Long count = Objects.firstNotNull(table.get(height, status), 0L);
    System.out.print("|" + count);
  }
  System.out.println();
}