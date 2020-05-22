import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;

import java.io.FileOutputStream;

class TopLeftCell {

 public static void main(String[] args) throws Exception{
  Workbook wb = new XSSFWorkbook();

  Sheet sheet = wb.createSheet("new sheet");
/*
  ((XSSFSheet)sheet).getCTWorksheet().getSheetViews().getSheetViewArray(0).setTopLeftCell("D10");
  ((XSSFSheet)sheet).setActiveCell(new CellAddress("E11"));
*/

  sheet.createFreezePane(2, 2); //C3 is top left cell of the scrollable pane
  ((XSSFSheet)sheet).getCTWorksheet().getSheetViews().getSheetViewArray(0).getPane().setTopLeftCell("C3");
  ((XSSFSheet)sheet).setActiveCell(new CellAddress("A1"));

  wb.write(new FileOutputStream("TopLeftCell.xlsx"));
  wb.close();
 }
}