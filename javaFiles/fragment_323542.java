public class ReadWriteExcelFile {  

    public static void main(String[] args) throws IOException {  
        String excelFileName = "C:\\temp\\Test.xlsx";//name of excel file  

        String sheetName = "Sheet1";//name of sheet  

        SXSSFWorkbook wb = new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows will be flushed to disk
        Sheet sheet = wb.createSheet(sheetName);  

//iterating r number of rows  
        for (int r = 0; r < 55555; r++) {  
            Row row = sheet.createRow(r);  

//iterating c number of columns  
            for (int c = 0; c < 5; c++) {  
                Cell cell = row.createCell(c);  
                cell.setCellValue("Cell " + r + " " + c);  
            }  
            if ( r % 1000 == 0) {
                System.out.println(r);
            }
        }  

        FileOutputStream out = new FileOutputStream(excelFileName);
        wb.write(out);
        out.close();
    }  
}