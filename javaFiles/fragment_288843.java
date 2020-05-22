...

ResultSet rs = c.createStatement().executeQuery(SQL);

employeeTableView.getColumns().clear();

for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {

    final int j = i;
    col = new TableColumn(rs.getMetaData().getColumnName(i + 1));

    ...

    employeeTableView.getColumns().add(col);
}

...