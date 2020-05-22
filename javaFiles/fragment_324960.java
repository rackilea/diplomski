public class MyOracleDialect extends Oracle10gDialect {
    @Override
    protected void registerFunctions() {
        super.registerFunctions();
        registerFunction("sub_days", new SQLFunctionTemplate(StandardBasicTypes.DATE, " date_sub(?1, INTERVAL ?2 DAY)"));
    } }