//attModel.addRow(new Object[]{rs.getInt(1),rs.getString(2)+" "+rs.getString(3),rs.getString(4)});

Vector<Object> row = new Vector<Object>();
row.addElement(rs.getInt(1));
row.addElement(rs.getString(2) + " " + rs.getString(3));
row.addElement(rs.getString(4));
row.addElement("Absent");
attModel.addRow( row );