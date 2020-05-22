try (PreparedStatement ps = conn.createStatement(myQueryString)) {
    // bind parameters
    try (ResultSet rs = rs = ps.executeQuery()) {}
        // process the results...
    }
} catch (java.sql.SQLException e) {
    log.error("an error!", e);
    throw new MyAppException("I'm sorry. Your query did not work.");
}