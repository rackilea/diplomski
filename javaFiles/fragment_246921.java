public class PGDialect extends PostgreSQLDialect{

    public PGDialect() {
        super();
        registerFunction("string_agg", new SQLFunctionTemplate( StandardBasicTypes.STRING, "string_agg(?1, ?2)"));
    }
}