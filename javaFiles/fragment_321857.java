public class MyOracleType implements SQLData{ 
    public static final String SQL_TYPE = "MYSCHEMA.MY_ORACLE_T";

    public String getSQLTypeName() {
        return SQL_TYPE;
    }