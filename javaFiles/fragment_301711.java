for(every row in the table) {
     String cell1 = sheet.getCell(0, row).getContents();
     String cell2 = sheet.getCell(1, row).getContents();
     String cell3 = sheet.getCell(2, row).getContents();
     String cell4 = sheet.getCell(3, row).getContents();
     String cell5 = sheet.getCell(4, row).getContents();
     String cell6 = sheet.getCell(5, row).getContents();

     MyClass record = new MyClass();
     record.timeColumn = Long.parseLong(cell1);
     record.pc1Column = Double.parseDouble(cell2);
     record.pc2Column = Double.parseDouble(cell3);
     record.ph1Column = Double.parseDouble(cell4);
     record.ph2Column = Double.parseDouble(cell5);
     record.ph3Column = Double.parseDouble(cell6);

     myTable.add(record);
}