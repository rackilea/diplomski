final ArrayTable<String, Integer, Object> table = ArrayTable.create(
    ImmutableList.of("1", "2", "3"), ImmutableList.of(0, 1, 2));

table.put("1", 0, "value1");
table.put("1", 1, "value2");
table.put("1", 2, "value3");

table.put("2", 0, "value11");
table.put("2", 1, "value22");
table.put("2", 2, "value33");

table.put("3", 0, "value111");
table.put("3", 1, "value222");
table.put("3", 2, "value333");

for (final Integer columnKey : table.columnKeyList()) {
  System.out.println(table.column(columnKey).values());
}
// prints:
// [value1, value11, value111]
// [value2, value22, value222]
// [value3, value33, value333]