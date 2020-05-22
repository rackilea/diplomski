for(int i = 0; i < jTable2.getRowCount(); i++) {
    data.put(convertRow(jTable2, i));
}

public Object[] convertRow(Table jTable2, int row) {
    rowLength = jTable2[0].length;
    Object[] row = new Object[rowLength];
    for (int i = 0; i < rowLength; i++) {
        Object datum = jTable2.getValueAt(row, i);
        if (datum != null) {
            row[i] = datum.toString();
        }
        else {
            row[i] = "Null entry"
        }
    }

    return row         
}