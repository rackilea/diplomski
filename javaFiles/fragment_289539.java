public static int mapParams(PreparedStatement ps, Object... args) throws SQLException {
    int i = 1;
    for (Object arg : args) {         
         if (arg instanceof Date) {
        ps.setTimestamp(i++, new Timestamp(((Date) arg).getTime()));
    } else if (arg instanceof Integer) {
        ps.setInt(i++, (Integer) arg);
    } else if (arg instanceof Long) {
        ps.setLong(i++, (Long) arg);
    } else if (arg instanceof Double) {
        ps.setDouble(i++, (Double) arg);
    } else if (arg instanceof Float) {
        ps.setFloat(i++, (Float) arg);
    } else {
        ps.setString(i++, (String) arg);
    }
   }
  }
}