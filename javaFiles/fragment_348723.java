public static void setParameters (final PreparedStatement stmt,
    final Object... param)
{
  for (int i=0; i<param.length; i++)
  {
      Object debug = param[i];
      String type = null;

      if (param[i] == null)
        stmt.setString(i+1, null);
      else if (param[i] instanceof java.sql.Time) 
      {
        stmt.setTime (
          i+1, 
          java.sql.Timestamp.valueof("1970-01-01 " + param[i] + ".000000000")
         );
      }