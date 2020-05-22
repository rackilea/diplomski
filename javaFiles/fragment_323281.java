Instant instant = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    try (Connection conn = DbConnection.getCon();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO test_table (timestamp) VALUES (FROM_UNIXTIME(?*0.001))");) {
        ps.setObject(1, instant.toEpochMilli());
        ps.executeUpdate();
        LOG.info("Instant: {} and long: {}", instant, instant.toEpochMilli());
    } catch (SQLException ex) {
        LOG.error(ex.getMessage());
    }