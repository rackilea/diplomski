import java.io.FileInputStream;

import org.apache.poi.xwpf.usermodel.*;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STStyleType;

import java.util.List;

public class WordGetRunStyles {

 public static void main(String[] args) throws Exception {

  FileInputStream fis = new FileInputStream("This is a Test.docx");
  XWPFDocument xdoc = new XWPFDocument(fis);

  List<XWPFParagraph> paragraphs = xdoc.getParagraphs();
  for (XWPFParagraph paragraph : paragraphs) {
   List<XWPFRun> runs = paragraph.getRuns();
   for (XWPFRun run : runs) {
    CTRPr cTRPr = run.getCTR().getRPr();
    if (cTRPr != null) {
     if (cTRPr.getRStyle() != null) {
      String styleID = cTRPr.getRStyle().getVal();
      System.out.println("Style ID=====================================================");
      System.out.println(styleID);
      System.out.println("=============================================================");
      XWPFStyle xStyle = xdoc.getStyles().getStyle(styleID);
      if (xStyle.getType() == STStyleType.CHARACTER) {
       System.out.println(xStyle.getCTStyle());
      }
     }
    }
   }
  }
 }
}