FileInputStream excelFile = new FileInputStream(new File("yourExcelsheet.xsls"));
Workbook workbook = new XSSFWorkbook(excelFile);
Sheet datatypeSheet = workbook.getSheetAt(0);
Iterator<Row> iterator = datatypeSheet.iterator();

//int columnCount = 4;  
String columnArray[] = new String[]{"column1","column2","column3","column4","column5","column6"};       

//iterate row-wise
while (iterator.hasNext()) {
    String sql="INSERT INTO tablename";
    String columnNames = "";
    String valueString = "";
    String value = "";      
    int i=0;
    Row currentRow = iterator.next();
    Iterator<Cell> cellIterator = currentRow.iterator();

    //iterate column-wise
     while (cellIterator.hasNext()) {
        Cell currentCell = cellIterator.next();     
        value = currentCell.getStringCellValue();

        if(i != 0)
        {
            columnNames += ",";
            valueString += ",";
        }
        columnNames += columnArray[i] ;
        valueString += value;
        i++;
    }

   sql += "(" + columnNames + ") values (" + valueString + ");";

   System.out.println(sql);

}