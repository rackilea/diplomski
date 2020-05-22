try (
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("/records.txt")), "UTF-8"));
    Connection connection = dataSource.getConnection();
    Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
) {
    statement.setFetchSize(Integer.MIN_VALUE);

    try (ResultSet resultSet = statement.executeQuery("SELECT col1, col2, col3 FROM sometable")) {
        while (resultSet.next()) {
            writer.append(resultSet.getString("col1")).append(",")
                  .append(resultSet.getString("col2")).append(",")
                  .append(resultSet.getString("col3")).println();
        }
    }
}