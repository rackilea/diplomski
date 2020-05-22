import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;

import java.io.FileOutputStream;

class TopLeftCell {

 public static void main(String[] args) throws Exception{
  Workbook wb = new XSSFWorkbook();

  Sheet sheet = wb.createSheet("new sheet");

  ((XSSFSheet)sheet).getCTWorksheet().getSheetViews().getSheetViewArray(0).setTopLeftCell("D10");
  ((XSSFSheet)sheet).setActiveCell(new CellAddress("E11"));

  wb.write(new FileOutputStream("TopLeftCell.xlsx"));
  wb.close();
 }
}