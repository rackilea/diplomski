// Dynamic field creation
Field<Integer> id = field(name("AUTHOR", "ID"), SQLDataType.INTEGER);
Field<String> lastName = field(name("AUTHOR", "LAST_NAME"), SQLDataType.VARCHAR);

// Same as before
Result<Record2<Integer, String>> result = create.newResult(id, lastName);
result.add(create.newRecord(id, lastName).values(1, "Orwell"));
mock[0] = new MockResult(1, result);