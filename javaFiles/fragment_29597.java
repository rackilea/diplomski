try {
    // first insert
    // second insert
} catch (SQLException e) {
    connection.rollback();
}