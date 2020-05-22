PreparedStatement stmt = conn.prepareStatement("select * from foo where (? is null and bar is null) or (bar = ?)");
col = 1;
setVarchar(stmt, col++, var);
setVarchar(stmt, col++, var);

void setVarchar(PreparedStatement stmt, int col, String var)
{
  if (var == null)
    stmt.setNull(col, java.sql.Types.VARCHAR);
  else
    stmt.setString(col, var);
}