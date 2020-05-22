// This part is initializing resources
try (Connection connection = getConnection();
     PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
    // This part is just statements
    preparedStatement.setString(1, positionName);
    preparedStatement.executeUpdate();
} catch (SQLException e) {
    e.printStackTrace();
}