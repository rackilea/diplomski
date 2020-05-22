int count;
try {
    count = ps.executeUpdate();
} catch (SQLException e) {
    throw new DaoException("Exception while executing update: " + e.getMessage());
}

if (count != 1) {
    // ...
}