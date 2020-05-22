package mypackage

import java.io.FileInputStream

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class ExcelUtils {

//  private var cellData: String = null;

  def getCellData(path: String, sheetName: String, rowNum: Int, colNum: Int): String = {
    val excelFileInputStream = new FileInputStream(path);

    val fileExtensionName = path.substring(path.indexOf("."));
    var cellData: String = null;

    if (fileExtensionName.equals(".xlsx")) {
      val excelWorkBookXlxs = new XSSFWorkbook(excelFileInputStream);
      val excelWorkSheetXlxs = excelWorkBookXlxs.getSheet(sheetName);
      val cell = excelWorkSheetXlxs.getRow(rowNum).getCell(colNum);
      cellData = cell.getStringCellValue();
    } else if (fileExtensionName.equals(".xls")) {
      val excelWorkBookXls = new HSSFWorkbook(excelFileInputStream);
      val excelWorkSheetXls = excelWorkBookXls.getSheet(sheetName);
      val cell = excelWorkSheetXls.getRow(rowNum).getCell(colNum);
      cellData = cell.getStringCellValue();
    }
    return cellData;
  }
}