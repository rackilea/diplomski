int affectedRows = stmt1.executeUpdate();

if (affectedRows == 0) {
    throw new SQLException("Insert Passenger error: no rows were affected.");
}

try (ResultSet generatedKeys = stmt1.getGeneratedKeys()) {
    if (generatedKeys.next()) {
        user.setId(generatedKeys.getLong(1));
    }
    else {
        throw new SQLException("Insert Passenger error: no ID obtained.");
    }
}