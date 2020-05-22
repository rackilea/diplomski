public class MyCustomOracleArrayType extends AbstractSqlTypeValue {
    private final Connection oracleCon;
    private final Object[] values;

    public MyCustomOracleArrayType(final Connection oracleCon, final Object[] values) {
        this.oracleCon = oracleCon;
        this.values = values;
    }

    @Override
    protected Object createTypeValue(final Connection con, final int sqlType, final String typeName)
            throws SQLException {
        Array array =  ((OracleConnection)oracleCon).createOracleArray("STRING_ARRAY", values);
        return array;
    }
  }