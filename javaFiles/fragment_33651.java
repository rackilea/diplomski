for (int column = 1; column <= columnCount; column++) {
     columnNames.add(metaData.getColumnName(column));
     System.out.println("ColumnNames "+columnNames );
}
DefaultTableModel datamodel = new DefaultTableModel(columnNames, 0);
table.setModel(datamodel);

while (resultSet.next()) {
    Vector<String> vector = new Vector<String>();
    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
        vector.add(resultSet.getString(columnIndex)); 
    }
    datamodel.addRow(vector);
}