public class DayOfWeekTypeHandler extends BaseTypeHandler<DayOfWeek> {
    @Override
    public void setNonNullParameter(
            PreparedStatement ps, int i, DayOfWeek parameter, JdbcType jdbcType
    ) throws SQLException {
        ps.setInt(i, parameter.getValue());
    }

    @Override
    public DayOfWeek getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return DayOfWeek.of(rs.getInt(columnName));
    }

    @Override
    public DayOfWeek getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return DayOfWeek.of(rs.getInt(columnIndex));
    }

    @Override
    public DayOfWeek getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return DayOfWeek.of(cs.getInt(columnIndex));
    }
}