public static Object[][] getTableAsMapObject(String xlFileName, String xlSheetName) throws Exception {
        Map<String, String> dataMap = null;
        Object[][] tabArray = null;

        String masterDataFilePath = "./data/MasterData.xlsx";
        try {
            FileInputStream ExcelFile = new FileInputStream("./data/" + xlFileName + ".xlsx");
            // Access the required test data sheet
            XSSFWorkbook excelWBook = new XSSFWorkbook(ExcelFile);
            XSSFSheet excelWSheet = excelWBook.getSheet(xlSheetName);
            row = excelWSheet.getRow(0);
            int totalCols = row.getLastCellNum();
            totalCols--;
            int startRow = 1;
            int startCol = 1;
            int ci;
            int totalRows = excelWSheet.getLastRowNum();
            int activeRows = 0;
            ci = 0;
            for (int i = startRow; i <= totalRows; i++, ci++) {
                if (getCellData(excelWSheet, i, 0).trim().toUpperCase().equals("YES")
                        || getCellData(excelWSheet, i, 0).trim().toUpperCase().equals("Y")) {
                    activeRows++;
                }
            }
            tabArray = new Object[activeRows][1]; //***<<< Changing 0 to 1 did the trick
            ci = 0;
            for (int i = startRow; i <= totalRows; i++) {
                if (getCellData(excelWSheet, i, 0).trim().toUpperCase().equals("YES")
                        || getCellData(excelWSheet, i, 0).trim().toUpperCase().equals("Y")) {
                    dataMap = new HashMap<String, String>();
                    for (int j = startCol; j <= totalCols; j++) {

                        String colName = getCellData(excelWSheet, 0, j);
                        if (colName.contains("_")) {
                            String[] bits = colName.split("_");
                            String lastOne = bits[bits.length-1];
                            if (lastOne.equalsIgnoreCase("key")) {
                                dataMap = getMasterDataSet(masterDataFilePath, bits[0], getCellData(excelWSheet, i, j), dataMap);
                            }
                        } else { dataMap.put(colName, getCellData(excelWSheet, i, j)); }
                    }
                    tabArray[ci][0] = dataMap;
                    dataMap = null;
                    ci++;
                }
            }
            excelWBook.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return (tabArray);
    }