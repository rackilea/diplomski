public class SchemaReWriter implements StatementLocator {
    @Override
    public String locate(String sql, StatementContext ctx) throws Exception {
        if (nonNull(Schema.name.get())) {
            sql = sql.replaceAll(":schema", Schema.name.get());
        }
        return sql;
    }
}