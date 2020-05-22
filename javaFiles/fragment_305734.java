String stringQuery = 
    "INSERT INTO banlist (name, reason, admin, time, temptime, IP)"
    + " VALUES (?, ?, ?, CURRENT_TIMESTAMP, NOW(), NULL)";

PreparedStatement statement = this.connection.prepareStatement(stringQuery);
statement.setString(1, testNick);
statement.setString(2, testPowod);
statement.setString(3, testAdmin);
int inserted = statement.executeUpdate();