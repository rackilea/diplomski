public class DB2Dialect extends org.hibernate.dialect.DB2400Dialect {
    public static String db;

    @Override
    public String getTableTypeString() {
        return " IN DATABASE " + db;
    }
}