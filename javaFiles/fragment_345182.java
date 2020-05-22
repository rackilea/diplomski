@Override
public String getNullableResult(ResultSet rs, int columnIndex)
throws SQLException
{
    return rs.getString(columnIndex);
}