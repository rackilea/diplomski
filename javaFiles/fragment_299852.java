public class CustomMySQLDialect extends MySQLDialect  {
    public MySQLDialectDataType() {
        registerHibernateType(Types.NVARCHAR, 255, "string");
        registerHibernateType(Types.BIGINT, "long");
    }
}