private static PreparedStatement prepareStatement(
    Connection conn, java.util.Date date)
    throws SQLException {
  final String sql = "SELECT ItemName, SUM(Unit) AS SoldUnit, "
      + "SUM(Total) AS TotalAmount, "
      + "SUM(Profit) AS TotalProfit "
      + "FROM InvoiceTable WHERE DateSO=? GROUP BY ItemName";
  PreparedStatement ps = conn.prepareStatement(sql);
  ps.setDate(1, new java.sql.Date(date.getTime()));
  return ps;
}