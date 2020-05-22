import java.io.FileOutputStream;
import java.io.FileInputStream;

import java.util.List;

import org.apache.poi.xwpf.usermodel.*;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;

/*
needs the full ooxml-schemas-1.3.jar as mentioned in https://poi.apache.org/faq.html#faq-N10025
since the CTRowImpl is not fully shipped with poi-ooxml-schemas-3.13-*.jar
*/

public class WordCleanTableRows {

 public static void main(String[] args) throws Exception {

  FileInputStream fis = new FileInputStream("document.docx");
  XWPFDocument doc = new XWPFDocument(fis);

  List<XWPFTable> tables = doc.getTables();
  XWPFTable table = tables.get(0);

  XWPFTableRow[] rows = table.getRows().toArray(new XWPFTableRow[0]);
  for (int r = 0; r < rows.length; r++) {
   if (r > 0) {
    XWPFTableRow row = rows[r];
    CTTc[] cells = row.getCtRow().getTcList().toArray(new CTTc[0]);
    for (int c = 0; c < cells.length; c++) {
     CTTc cTTc = cells[c];
     //clear only the paragraphs in the cell, keep cell styles
     cTTc.setPArray(new CTP[] {CTP.Factory.newInstance()});
     cells[c] = cTTc;
    }
    row.getCtRow().setTcArray(cells);
    //System.out.println(row.getCtRow());
   }
  }

  doc.write(new FileOutputStream("new document.docx"));

 }
}