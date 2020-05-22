@Override
public void exception(ExecuteContext ctx) {
    SQLException ex = ctx.sqlException();
    Statement stmt = ctx.statement();
    Connection con = ctx.getConnection();
    DataSource dataSource = ctx.getDataSource();
    JdbcUtils.closeStatement(stmt);
    ctx.exception(getExceptionTranslator(dataSource).translate("jOOQ", ctx.sql(), ex));
}