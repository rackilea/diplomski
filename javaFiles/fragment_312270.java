public static Person getRow(int rowNumber) throws SQLException {
    String sql = "SELECT * FROM profiles";
    try (
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
    ) {
        if (resultSet.absolute(rowNumber)) {
            return new Person(resultSet.getInt("personId"), resultSet.getString("name"), 
                       resultSet.getString("family"), resultSet.getString("nationalId"));
        } else {
            System.err.println("No row were found !");
            return null;
        }
    } catch (SQLException e) {
        System.err.println(e);
        return null;
    }
}