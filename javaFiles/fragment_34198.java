...
// You decide, whether any given statement returns results, and how many
else if (sql.toUpperCase().startsWith("SELECT")) {

    // Always return one record
    Result<Record2<Integer, String>> result = create.newResult(AUTHOR.ID,AUTHOR.LAST_NAME);
    result.add(create
        .newRecord(AUTHOR.ID, AUTHOR.LAST_NAME)
        .values(1, "Orwell"));
    mock[0] = new MockResult(1, result);
}
...