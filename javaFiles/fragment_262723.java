Vector<String> rows = new Vector<String>();
 Vector<Vector> dBdata = new Vector<Vector>();

// Add Columns to table
for (int i = 1; i < data.getColumnCount(); i++) {
    colum[i] = data.getColumnName(i);
    model.addColumn(colum[i]);
}

while (resultaat.next()) {
    // add column data to rows vector
            // Make sure that all data type is in string because of generics
    rows.add(resultaat.getString("columnName1"));
    rows.add(resultaat.getString("columnName2"));
    rows.add(resultaat.getString("columnName3"));

    // add whole row vector to dBdata vector
    dBdata.addElement(rows);
}
model.addRow(dBdata);