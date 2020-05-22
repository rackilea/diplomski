DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
     String data1 = something1.columnOneFromDB;
     String data2 = something2.columnTwoFromDB;
     String data3 = something3.columnThreeFromDB();
     String data4 = something4.columnFourFromDB();

     Object[] row = { data1, data2, data3, data4 };

     model.addRow(row);