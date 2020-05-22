import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;

import java.io.FileOutputStream;

class TopLeftCell {

 public static void main(String[] args) throws Exception{
  Workbook wb = new XSSFWorkbook();

  Sheet sheet = wb.createSheet("new sheet");

  sheet.createFreezePane(2, 0); //C1 is top left cell of the scrollable pane.
  //But if the fixed pane contains no rows, as in this example, then setting the row in 
  //getPane().setTopLeftCell is meaningless. Then the top row must be set in the SheetView.
  //Example: Row 6 shall be the top row:
  ((XSSFSheet)sheet).getCTWorksheet().getSheetViews().getSheetViewArray(0).setTopLeftCell("A6");
  ((XSSFSheet)sheet).getCTWorksheet().getSheetViews().getSheetViewArray(0).getPane().setTopLeftCell("C1");
  ((XSSFSheet)sheet).setActiveCell(new CellAddress("C6"));

  wb.write(new FileOutputStream("TopLeftCell.xlsx"));
  wb.close();
 }
}