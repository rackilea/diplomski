import java.io.FileOutputStream;
import java.io.FileInputStream;

import java.util.List;

import org.apache.poi.xwpf.usermodel.*;

public class WordCleanTableRows2 {

 public static void main(String[] args) throws Exception {

  FileInputStream fis = new FileInputStream("document.docx");
  XWPFDocument doc = new XWPFDocument(fis);

  List<XWPFTable> tables = doc.getTables();
  XWPFTable table = tables.get(0);

  XWPFTableRow[] rows = table.getRows().toArray(new XWPFTableRow[0]);
  for (int r = 0; r < rows.length; r++) {
   if (r > 0) {
    XWPFTableRow row = rows[r];
    table.removeRow(1); //remove second row. others shift upwards
    table.createRow(); //add new row at the end
   }
  }

  doc.write(new FileOutputStream("new document.docx"));

 }
}