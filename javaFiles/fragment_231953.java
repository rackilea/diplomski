import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;

class ReadExcelSpecialNumberFormat {

 public static void main(String[] args) throws Exception {

  Workbook workbook  = WorkbookFactory.create(new FileInputStream("ExcelSpecialNumberFormat.xlsx"));

  DataFormatter dataFormatter = new DataFormatter();

  CreationHelper creationHelper = workbook.getCreationHelper();

  FormulaEvaluator formulaEvaluator = creationHelper.createFormulaEvaluator();

  Sheet sheet = workbook.getSheetAt(0);

  for (Row row : sheet) {
   for (Cell cell : row) {
    CellStyle cellStyle = cell.getCellStyle();
    String dataFormatString = cellStyle.getDataFormatString();
    if (dataFormatString != null && dataFormatString.contains(";"))
     cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat(dataFormatString+";"));
    String cellContent = dataFormatter.formatCellValue(cell, formulaEvaluator);
    System.out.print(cellContent + " ");
   }
   System.out.println();
  }

  workbook.close();

 }
}