// keep 100 rows in memory, exceeding rows will be flushed to disk
SXSSFWorkbook wb = new SXSSFWorkbook(100); 
    Sheet sh = wb.createSheet();
    for(int rownum = 0; rownum < 1000; rownum++){
        //When the row count reaches 101, the row with rownum=0 is flushed to disk and removed from memory, 
        //when rownum reaches 102 then the row with rownum=1 is flushed, etc. 
        Row row = sh.createRow(rownum);
        for(int cellnum = 0; cellnum < 10; cellnum++){
            Cell cell = row.createCell(cellnum);
            String address = new CellReference(cell).formatAsString();
            cell.setCellValue(address);
        }

    }