FileInputStream input_document = new FileInputStream(new File("testme.xlsx"));
    XSSFWorkbook my_xlsx_workbook = new XSSFWorkbook(input_document);
    XSSFSheet sheet = my_xlsx_workbook.getSheetAt(0);
    XSSFTable my_table = sheet.createTable();

    CTTable cttable = my_table.getCTTable();
    CTTableStyleInfo table_style = cttable.addNewTableStyleInfo();
    table_style.setName("TableStyleMedium9");
    table_style.setShowColumnStripes(true);
    table_style.setShowRowStripes(true);
    AreaReference my_data_range = new AreaReference(new CellReference(9, 0), new CellReference(18, 19), SpreadsheetVersion.EXCEL2007);
    cttable.setRef(my_data_range.formatAsString());
    cttable.setDisplayName("MYTABLE");      /* this is the display name of the table */
    cttable.setName("Test");    /* This maps to "displayName" attribute in &lt;table&gt;, OOXML */
    cttable.setId(1L); //id attribute against table as long value
    for(int x = my_xlsx_workbook.getSheetAt(0).getRow(2).getRowNum();x < my_xlsx_workbook.getSheetAt(0).getLastRowNum(); x++) {
        //add columns for each row
        CTTableColumns columns = cttable.addNewTableColumns();
        //define number of columns for each row
        columns.setCount(my_xlsx_workbook.getSheetAt(0).getRow(x).getLastCellNum());
        //loop the columns to add value and id
        for (int i = 0; i < my_xlsx_workbook.getSheetAt(0).getRow(x).getLastCellNum(); i++) {
            CTTableColumn column = columns.addNewTableColumn();
            column.setName(my_xlsx_workbook.getSheetAt(0).getRow(x).getCell(i).getStringCellValue());
            column.setId(my_xlsx_workbook.getSheetAt(0).getRow(x).getCell(i).getColumnIndex() + i);
        }
        //add each row into the table
        cttable.setTableColumns(columns);
    }
    sheet.setAutoFilter(new CellRangeAddress(2,2,0,19));

    /* Write output as File */
    FileOutputStream fileOut = new FileOutputStream("Excel_Format_As_Table.xlsx");
    my_xlsx_workbook.write(fileOut);
    fileOut.close();
}