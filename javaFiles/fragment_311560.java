try (Connection con = ConnectionManager.dbconnection();
    Statement statement = con.createStatement();
    ResultSet resultSet = statement.executeQuery(query)) {
        while(resultSet.next) {
            //Add desired values to data structure
        }
}