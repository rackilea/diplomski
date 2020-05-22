static Map<String, Function<String,Statement> map = new HashMap<>();
static
{
    map.put("SELECT", SelectStatement::new);
    // etc...
}

public static Statement createStatement(String stmtSql)
{
    ...
    return map.get(fstWord).apply(stmtSql);
}