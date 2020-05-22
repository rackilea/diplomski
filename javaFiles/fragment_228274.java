Session session = entityManager.unwrap(Session.class);
session.doWork(connection -> {

    try (PreparedStatement st = connection.prepareStatement(
            "INSERT INTO post (id, title) " +
            "VALUES (?, ?)")) {
        for (long i = 0; i < 5; i++) {
            st.setLong(1, i % 2);
            st.setString(2, String.format("High-Performance Java Persistence, Part %d", i));
            st.addBatch();
        }
        st.executeBatch();
    } catch (BatchUpdateException e) {
        LOGGER.info("Batch has managed to process {} entries", e.getUpdateCounts().length);
    }
});