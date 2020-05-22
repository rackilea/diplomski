public class MyOracleDialect extends Oracle10gDialect {

    public MyOracleDialect() {
        super();
        registerHibernateType(-101, DateType.INSTANCE.getName());
    }
}