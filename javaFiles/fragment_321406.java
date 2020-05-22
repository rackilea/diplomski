/**
 * @return the generated primary key, the Student ID.
 */
int registerStudent(Connection conn, String toBeInserted, String insertedTo)
        throws SQLException {
    String query = "INSERT INTO Registrations(ToBeInserted, InsertedInto) VALUES(?, ?)";

    try (PreparedStatement ps = conn.prepareStatement(query),
            Statement.RETURN_GENERATED_KEYS) {
        ps.setString(1, toBeInserted);
        ps.setString(2, insertedTo);
        int updateCount = ps.executeUpdate();                        
        if (updateCount == 1) {
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    return id;
                }
            }
            throw new SQLException("No primary key generated");
        } else {
            SQLWarning warning = ps.getWarnings();
            Logger.getLogger(Xyz.class.getName()).info("Not added, values: "
                + toBeInserted + " were not inserted into "+ insertedTo + ": " + warning);
            throw new SQLException("Not added");
        }
    }
}