String query = "SELECT sender AS service FROM messages UNION SELECT receiver AS service FROM messages ORDER BY service";
    ResultSet rs = ps.executeQuery(query);
    while (rs.next()) {
        String value = rs.getString("sender"); // instead it should be "service"
        // Some other actions
    }