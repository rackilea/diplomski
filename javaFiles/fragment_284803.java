public static void printResultColumns(ResultSet resultSet) throws SQLException {
    ResultSetMetaData rsmd = resultSet.getMetaData();
    int columnCount = rsmd.getColumnCount();

    while (resultSet.next()) {
        // you get a single result row in here, not the entire ResultSet
        for (int i = 1; i <= columnCount; i++) {
            switch (rsmd.getColumnType(i)) {
            case Types.VARCHAR:
            case Types.LONGVARCHAR:
            case Types.CHAR:
                System.out.println(resultSet.getString(i));
                break;
            case Types.DOUBLE:
                System.out.println(resultSet.getDouble(i));
                break;
            case Types.INTEGER:
                System.out.println(resultSet.getInt(i));
                break;
            case Types.DATE:
                System.out.println(resultSet.getDate(i).toString());
                break;
            case Types.TIMESTAMP:
                System.out.println(resultSet.getTimestamp(i).toString());
                break;
            case Types.BOOLEAN:
                System.out.println(resultSet.getBoolean(i));
                break;
            case Types.DECIMAL:
            case Types.NUMERIC:
                System.out.println(resultSet.getBigDecimal(i));
                break;
            default:
                System.out.println("This column type (" 
                        + rsmd.getColumnTypeName(i)
                        + ") is currently not supported in method \"printResultColumns\""
                        + ".\nAdd it as case there.");
            }
        }
    }
}