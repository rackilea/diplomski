String[] names = new String[] {"Isaac", "Hello"};
PreparedStatement statement = connection.prepareStatement("select * from myDatabase.myTable where name = ?");

for (String name: names) {
    statement.setString(1, name);    
    ResultSet resultSet = statement.executeQuery();
    ...
    ...
    statement.clearParameters();
}