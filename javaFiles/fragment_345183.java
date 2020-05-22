@Override
public StringBuilder getNullableResult(ResultSet rs, int columnIndex)
throws SQLException
{
    final StringBuilder returnValue = new StringBuilder();
    final byte[] value = rs.getbytes(columnIndex);

    // add the bytes to the StringBuilder.

    return returnValue;
}