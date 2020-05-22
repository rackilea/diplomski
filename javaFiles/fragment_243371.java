assertEquals(v1.Public.PUBLIC, v2.Public.PUBLIC);

List<Table<?>> tables1 = v1.Public.PUBLIC.getTables();
List<Table<?>> tables2 = v2.Public.PUBLIC.getTables();
assertEquals(tables1, tables2);

for (int i = 0; i < tables1.size(); i++) {
    Table<?> table1 = tables1.get(i);
    Table<?> table2 = tables2.get(i);

    assertArrayEquals(format("Fields differ for %s and %s", table1, table2),
        table1.fields(), table2.fields());
    assertEquals(format("Primary keys differ for %s and %s", table1, table2),
        table1.getPrimaryKey(), table2.getPrimaryKey());
    assertEquals(format("Schemas differ for %s and %s", table1, table2),
        table1.getSchema(), table2.getSchema());
    assertEquals(format("Identities differ for %s and %s", table1, table2),
        table1.getIdentity(), table2.getIdentity());
    assertEquals(format("Keys differ for %s and %s", table1, table2),
        table1.getKeys(), table2.getKeys());
    assertEquals(format("References differ for %s and %s", table1, table2),
        table1.getReferences(), table2.getReferences());
}