for (int row = 0; row < table.getRowCount(); row++) {
     String people = table.getValueAt(row, 0).toString();
     String place = table.getValueAt(row, 1).toString();
     String organisation = table.getValueAt(row, 2).toString();
     String event = table.getValueAt(row, 3).toString();
     int mentions = (int)table.getValueAt(row, 4);
     //...
 }