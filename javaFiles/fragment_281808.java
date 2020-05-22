import java.io.FileOutputStream;
import java.io.FileInputStream;

import java.util.List;

import org.apache.poi.xwpf.usermodel.*;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;

import java.math.BigInteger;

public class WordCleanTableRows3 {

 public static void main(String[] args) throws Exception {

  FileInputStream fis = new FileInputStream("document.docx");
  XWPFDocument doc = new XWPFDocument(fis);

  List<XWPFTable> tables = doc.getTables();
  XWPFTable table = tables.get(0);

  XWPFTableRow[] rows = table.getRows().toArray(new XWPFTableRow[0]);
  for (int r = 0; r < rows.length; r++) {
   if (r > 0) {
    XWPFTableRow row = rows[r];
    List<XWPFTableCell> cells = row.getTableCells();
    for (XWPFTableCell cell : cells) {
     //get CTTc and replace the CTPArray with one empty CTP
     cell.getCTTc().setPArray(new CTP[] {CTP.Factory.newInstance()});

     //set some default styles for the paragraphs in the cells:
     //http://grepcode.com/file/repo1.maven.org/maven2/org.apache.poi/ooxml-schemas/1.1/org/openxmlformats/schemas/wordprocessingml/x2006/main/CTParaRPr.java  
     CTP cTP = cell.getCTTc().getPArray(0);
     cTP.addNewPPr();
     cTP.getPPr().addNewRPr();
     cTP.getPPr().getRPr().addNewB().setVal(STOnOff.ON);
     cTP.getPPr().getRPr().addNewColor().setVal("FF0000");
     cTP.getPPr().getRPr().addNewSz().setVal(BigInteger.valueOf(40));
    }
   }
  }

  doc.write(new FileOutputStream("new document.docx"));

 }
}