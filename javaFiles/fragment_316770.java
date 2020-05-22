import java.io.*;
import org.apache.poi.xwpf.usermodel.*;

import  org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;

public class WordInsertTableRow {

 public static void main(String[] args) throws Exception {

  XWPFDocument doc = new XWPFDocument(new FileInputStream("source.docx"));

  XWPFTable table = doc.getTableArray(0);

//insert new row, which is a copy of row 2, as new row 3:
  XWPFTableRow oldRow = table.getRow(1);
  CTRow ctrow = CTRow.Factory.parse(oldRow.getCtRow().newInputStream());
  XWPFTableRow newRow = new XWPFTableRow(ctrow, table);

  int i = 1;
  for (XWPFTableCell cell : newRow.getTableCells()) {
   for (XWPFParagraph paragraph : cell.getParagraphs()) {
    for (XWPFRun run : paragraph.getRuns()) {
     run.setText("New row 3 cell " + i++, 0);
    }
   }
  }

  table.addRow(newRow, 2);

//insert new last row, which is a copy previous last row:
  XWPFTableRow lastRow = table.getRows().get(table.getNumberOfRows() - 1);
  ctrow = CTRow.Factory.parse(lastRow.getCtRow().newInputStream());
  newRow = new XWPFTableRow(ctrow, table);

  i = 1;
  for (XWPFTableCell cell : newRow.getTableCells()) {
   for (XWPFParagraph paragraph : cell.getParagraphs()) {
    for (XWPFRun run : paragraph.getRuns()) {
     run.setText("New last row cell " + i++, 0);
    }
   }
  }

  table.addRow(newRow);

  doc.write(new FileOutputStream("result.docx"));
  doc.close();

 }
}