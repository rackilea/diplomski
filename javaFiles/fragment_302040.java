public class CustomOracleDialect extends Oracle10gDialect {

    public CustomOracleDialect() {
        super();
        registerColumnType(Types.NVARCHAR, "nvarchar2($l)");
        registerHibernateType(Types.NVARCHAR, StandardBasicTypes.STRING.getName());
    }
}