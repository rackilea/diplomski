Connection connection = DriverManager.getConnection("URL", "USERNAME", "PASSWORD");
PreparedStatement statement = connection.prepareStatement("select * from table");
ResultSet resultSet = statement.executeQuery();

if (resultSet != null) {
    while (resultSet.next()) {
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {

            int type = resultSetMetaData.getColumnType(i);
            if (type == Types.VARCHAR || type == Types.CHAR) {
                 System.out.println(resultSet.getString(i));
            } else {
                 System.out.println(resultSet.getLong(i));
            }
        }

         System.out.println("-----------");
    }
}