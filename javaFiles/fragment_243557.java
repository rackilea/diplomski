import java.io.*;

import org.apache.poi.xwpf.usermodel.*;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;

public class CreateWordXSSFHyperlinkRun {

 static XWPFHyperlinkRun createHyperlinkRun(XWPFParagraph paragraph, String uri) {
  String rId = paragraph.getDocument().getPackagePart().addExternalRelationship(
    uri, 
    XWPFRelation.HYPERLINK.getRelation()
   ).getId();

  CTHyperlink cthyperLink=paragraph.getCTP().addNewHyperlink();
  cthyperLink.setId(rId);
  cthyperLink.addNewR();

  return new XWPFHyperlinkRun(
    cthyperLink,
    cthyperLink.getRArray(0),
    paragraph
   );
 }

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument();

  XWPFParagraph paragraph = document.createParagraph();
  XWPFRun run = paragraph.createRun();
  run.setText("This is a text paragraph having ");

  XWPFHyperlinkRun hyperlinkrun = createHyperlinkRun(paragraph, "https://www.google.de");
  hyperlinkrun.setText("a link to Google");
  hyperlinkrun.setColor("0000FF");
  hyperlinkrun.setUnderline(UnderlinePatterns.SINGLE);

  run = paragraph.createRun();
  run.setText(" in it.");

  paragraph = document.createParagraph();

  paragraph = document.createParagraph();
  run = paragraph.createRun();
  run.setText("This is a text paragraph having ");

  hyperlinkrun = createHyperlinkRun(paragraph, "./test.pdf"); //path in URI is relative to the Word document file
  hyperlinkrun.setText("a link to a file");
  hyperlinkrun.setColor("0000FF");
  hyperlinkrun.setUnderline(UnderlinePatterns.SINGLE);
  hyperlinkrun.setBold(true);
  hyperlinkrun.setFontSize(20);

  run = paragraph.createRun();
  run.setText(" in it.");

  document.write(new FileOutputStream("CreateWordXSSFHyperlinkRun.docx"));
  document.close();

 }
}