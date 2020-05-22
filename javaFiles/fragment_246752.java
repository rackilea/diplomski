public class writeExcel extends globalVariables {
        public static void write(int row, int column, String result) throws InvalidFormatException {


            try {
                InputStream inp = new FileInputStream("/SQLInjection.xlsx");
                org.apache.poi.ss.usermodel.Workbook wb = WorkbookFactory.create(inp);
                Sheet sheet = wb.getSheet("Results");
              //  Sheet sheet = wb.getSheet(0);
                Row sheetRow = sheet.getRow(row);
                Cell cell = sheetRow.getCell(column);
                if (cell == null) {
                    cell = sheetRow.createCell(column);
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                }
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(result);
                FileOutputStream fileOut = new FileOutputStream("/SQLInjection.xlsx");
                wb.write(fileOut);
                fileOut.close();
              //  System.out.println("Results updated in Excel Sheet");

            } catch (IOException ex) {

            } 
        }
     /*  public static void main(String[] args) throws BiffException, IOException, InvalidFormatException {
            for (int i = 1;i <= 10;i++) {
                //excelLog("Exec" + i, "PASS" + i, i);
                System.out.println("Test");
                write(i,1,"Test", "PASS");
            } 
       }*/
    }