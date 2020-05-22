try (final Statement s = conn.createStatement()) {
    final ResultSet rs = s.executeQuery(sql);
    while (rs.next()) {
        // process each row of the result
    }
}  // statement is auto-closed