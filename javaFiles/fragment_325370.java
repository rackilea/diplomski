public void setString(PreparedStatement ps, int parameterIndex, String str) throws SQLException
{
    if(str.equalsIgnoreCase("NULL"))
        ps.setNull(parameterIndex, java.sql.Types.INTEGER);
    else
        ps.setString(parameterIndex, str);
}