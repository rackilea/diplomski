public class ResultSetDataProvider implements DataProvider {
    private ResultSet resultSet;

    public ResultSetDataProvider(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public BigInteger getBigInteger(int columnIndex) {
        BigDecimal bigDecimal = resultSet.getBigDecimal(columnIndex);
        return bigDecimal != null ? bigDecimal.toBigInteger() : null;
    }

    // ...
}