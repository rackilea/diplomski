LocalDate easter = LocalDate.of(2016, Month.MARCH, 27);

// Get all content from Easter Day (Mar 27, 2016)
String sql = "SELECT * FROM Contents WHERE contentDate >= ? and contentDate < ?";
try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    stmt.setDate(1, java.sql.Date.valueOf(easter));
    stmt.setDate(2, java.sql.Date.valueOf(easter.plusDays(1)));
    try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            //code here
        }
    }
}