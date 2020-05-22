public static void main(String[] args) throws FileNotFoundException, IOException, InvalidFormatException {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = (XSSFSheet) wb.createSheet();

        //Create some data to build the pivot table on
        setCellData(sheet);

        XSSFPivotTable pivotTable = sheet.createPivotTable(new AreaReference("A1:D4"), new CellReference("H5"));
        //Configure the pivot table
        //Use first column as row label
        pivotTable.addRowLabel(0);
        //Sum up the second column
        pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 1);
        //Set the third column as filter
        pivotTable.addColumnLabel(DataConsolidateFunction.AVERAGE, 2);
        //Add filter on forth column
        pivotTable.addReportFilter(3);

        FileOutputStream fileOut = new FileOutputStream("ooxml-pivottable.xlsx");
        wb.write(fileOut);
        fileOut.close();
    }