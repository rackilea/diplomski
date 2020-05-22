public TableModel getTableModel(ResultSet resultSet) throws SQLException {    
    ResultSetMetaData metaData = resultSet.getMetaData();        

    int columnCount = metaData.getColumnCount(); // columns number
    String[] columnNames = new String[columnCount];
    final Class[] columnClasses = new Class[columnCount];

    for (int i = 1; i <= columnCount; i++) {
        columnNames[i-1] = metaData.getColumnName(i); // fill columns names
        try {
            columnClasses[i-1] = Class.forName(metaData.getColumnClassName(i)); // fill column classes
        } catch (ClassNotFoundException ex) {
            // Log the exception here
        }
    }

    resultSet.last();
    int rowCount = resultSet.getRow(); // get rows number
    resultSet.beforeFirst();

    Object[][] data = new Object[rowCount][columnCount];
    int currentRow = 0;
    while (resultSet.next()) {
        for (int currentColumn = 1; currentColumn <= columnCount; currentColumn++) {
            data[currentRow][currentColumn - 1] = resultSet.getObject(currentColumn); // fill data set
         }
         currentRow++;
    }

    TableModel model = new DefaultTableModel(data, columnNames) {
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return columnClasses[columnIndex];
        }
    }
    return model;    
}