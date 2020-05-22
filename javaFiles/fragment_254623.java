ResultSetMetaData metaData = resultSet.getMetaData();

while (resultSet.next()) {
    for (int i=1; i < metaData.getColumnCount(); i++) {
        Object x = resultSet.getObject(i);
    }
}