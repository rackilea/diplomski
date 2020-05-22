JTable printTable = new JTable(table.getModel());
printTable.setSize(printTable.getPreferredSize());
JTableHeader tableHeader = printTable.getTableHeader();
tableHeader.setSize(tableHeader.getPreferredSize());

printTable.setShowHorizontalLines(false);
printTable.setShowVerticalLines(false);
printTable.print(JTable.PrintMode.FIT_WIDTH);