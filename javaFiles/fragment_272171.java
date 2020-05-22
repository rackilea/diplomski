import java.io.*;
import org.apache.poi.xwpf.usermodel.*;

import java.awt.Desktop;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class WordRemoveParagraph {

 /*
  * Deletes the given paragraph.
  */

 public static void deleteParagraph(XWPFParagraph p) {
  XWPFDocument doc = p.getDocument();
  int pPos = doc.getPosOfParagraph(p);
  //doc.getDocument().getBody().removeP(pPos);
  doc.removeBodyElement(pPos);
 }

 public static void main(String[] args) throws IOException, InvalidFormatException {

  XWPFDocument doc = new XWPFDocument(new FileInputStream("source.docx"));

  int pNumber = doc.getParagraphs().size() -1;
  while (pNumber >= 0) {
   XWPFParagraph p = doc.getParagraphs().get(pNumber);
   if (p.getParagraphText().contains("delete")) {
    deleteParagraph(p);
   }
   pNumber--;
  }

  FileOutputStream out = new FileOutputStream("result.docx");
  doc.write(out);
  out.close();
  doc.close();

  System.out.println("Done");
  Desktop.getDesktop().open(new File("result.docx"));

 }

}