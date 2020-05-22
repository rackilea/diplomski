Vector<String> rowOne = new Vector<String>();
rowOne.addElement("R1C1");
rowOne.addElement("R1C2");

Vector<String> rowTwo = new Vector<String>();
rowTwo.addElement("R2C1");
rowTwo.addElement("R2C2");

Vector<String> cols = new Vector<String>();

Vector<Vector> vecRow = new Vector<Vector>();
vecRow.addElement(rowOne);
vecRow.addElement(rowTwo);
cols.addElement("Col1");
cols.addElement("Col2");
JTable table = new JTable(vecRow, cols);