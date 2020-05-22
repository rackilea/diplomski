try (Connection con = datasource.getConnection()) {
    try (PreparedStatement stm1 = con.prepareStatement(getSQL())) {
        stm1.setString(1, owner);
        stm1.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
        stm1.setInt(3, count);

        int updateCount = stm1.executeUpdate();
    }

    try (PreparedStatement stm2 = con.prepareStatement(getSQL2())) {
        stm2.setString(1, owner);
        try (ResultSet rs = stm2.executeQuery()) {

            List<Object> results = new ArrayList<>();
            while(rs.next()) {
                results.add(create(rs));
            }
            return results;
        }
    }
} catch (SQLException e) {
    throw new RuntimeException("Failed to claim message", e);
}