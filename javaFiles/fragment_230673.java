String[] colNames = { "email", "already_linked", "account_link_timestamp" };
String query = "select " + Stream.of(colNames).collect(Collectors.joining(", "))
        + "from email_accounts where already_linked = false for update";
try (Connection conn = getConnection(); // Make sure conn.setAutoCommit(false);
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery(query)) {
    while (rs.next()) {
        // Get the current values, if you need them.
        String email = rs.getString(colNames[0]);
        boolean linked = rs.getBoolean(colNames[1]);
        Timestamp time = rs.getTimestamp(colNames[2]);
        // ...
        rs.updateBoolean(colNames[1], true);
        rs.updateTimestamp(colNames[2], //
                new Timestamp(System.currentTimeMillis()));
        rs.updateRow();
    }
} catch (SQLException e) {
    e.printStackTrace();
}