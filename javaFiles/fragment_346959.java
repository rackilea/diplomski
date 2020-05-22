XSSFTable table = sheet.createTable();
//XSSFTable table = sheet.createTable(null); //since apache poi 4.0.0
CTTable cttable = table.getCTTable();

cttable.setDisplayName("Table1");
cttable.setId(1);
cttable.setName("Test");
**cttable.setRef("A1:C11");**
cttable.setTotalsRowShown(false);