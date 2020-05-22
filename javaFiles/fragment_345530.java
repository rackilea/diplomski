import java.io.*;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;

import org.apache.xmlbeans.XmlCursor;

import java.util.*; 

import java.math.BigInteger;

public class WordReadAndRewrite {

 static void addItems(XWPFTableCell cell, XWPFParagraph paragraph, Set<String> items) {
  XmlCursor cursor = null;
  XWPFRun run = null;
  CTR cTR = null; // for a deep copy of the run's low level object

  BigInteger numID = paragraph.getNumID();
  int indentationLeft = paragraph.getIndentationLeft();
  int indentationHanging = paragraph.getIndentationHanging();

  boolean first = true;
  for (String item : items) {
   if (first) {
    for (int r = paragraph.getRuns().size()-1; r > 0; r--) {
     paragraph.removeRun(r);
    }
    run = (paragraph.getRuns().size() > 0)?paragraph.getRuns().get(0):null;
    if (run == null) run = paragraph.createRun();
    run.setText(item, 0);
    cTR = (CTR)run.getCTR().copy(); // take a deep copy of the run's low level object
    first = false;
   } else {
    cursor = paragraph.getCTP().newCursor();
    boolean thereWasParagraphAfter = cursor.toNextSibling(); // move cursor to next paragraph 
                                                             // because the new paragraph shall be **after** that paragraph
                                                             // thereWasParagraphAfter is true if there is a next paragraph, else false
    if (thereWasParagraphAfter) {
     paragraph = cell.insertNewParagraph(cursor); // insert new paragraph if there are next paragraphs in cell
    } else {
     paragraph = cell.addParagraph(); // add new paragraph if there are no other paragraphs present in cell
    }

    paragraph.setNumID(numID); // set template paragraph's numbering Id
    paragraph.setIndentationLeft(indentationLeft); // set template paragraph's indenting from left
    if (indentationHanging != -1) paragraph.setIndentationHanging(indentationHanging); // set template paragraph's hanging indenting
    run = paragraph.createRun();
    if (cTR != null) run.getCTR().set(cTR); // set template paragraph's run formatting
    run.setText(item, 0);
   }
  }
 }

 public static void main(String[] args) throws Exception {

  Map<String, Set<String>> replaceKeyValue = new HashMap<String, Set<String>>();
  replaceKeyValue.put("[AllowedEntities]", new HashSet<>(Arrays.asList("allowed 1", "allowed 2", "allowed 3")));
  replaceKeyValue.put("[OptionalEntities]", new HashSet<>(Arrays.asList("optional 1", "optional 2", "optional 3")));
  replaceKeyValue.put("[NotAllowedEntities]", new HashSet<>(Arrays.asList("not allowed 1", "not allowed 2", "not allowed 3")));

  XWPFDocument document = new XWPFDocument(new FileInputStream("WordTemplate.docx"));
  List<XWPFTable> tables = document.getTables();
  for (XWPFTable table : tables) {
   List<XWPFTableRow> rows = table.getRows();
   for (XWPFTableRow row : rows) {
    List<XWPFTableCell> cells = row.getTableCells();
    for (XWPFTableCell cell : cells) {

     int countParagraphs = cell.getParagraphs().size();
     for (int p = 0; p < countParagraphs; p++) { // do not for each since new paragraphs were added
      XWPFParagraph paragraph = cell.getParagraphArray(p);

      String placeholder = paragraph.getText();
      placeholder = placeholder.trim(); // this is the tricky part to get really the correct placeholder

      Set<String> items = replaceKeyValue.get(placeholder);
      if (items != null) {
       addItems(cell, paragraph, items);
      }
     }

    }
   }
  }

  FileOutputStream out = new FileOutputStream("Result.docx");
  document.write(out);
  out.close();
  document.close();

 }
}