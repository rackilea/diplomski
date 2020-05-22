import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;

import java.math.BigInteger;

public class CreateWordHyperlinkBookmark {

 static XWPFHyperlinkRun createHyperlinkRunToAnchor(XWPFParagraph paragraph, String anchor) throws Exception {
  CTHyperlink cthyperLink=paragraph.getCTP().addNewHyperlink();
  cthyperLink.setAnchor(anchor);
  cthyperLink.addNewR();
  return new XWPFHyperlinkRun(
    cthyperLink,
    cthyperLink.getRArray(0),
    paragraph
   );
 }

 static XWPFParagraph createBookmarkedParagraph(XWPFDocument document, String anchor, int bookmarkId) {
  XWPFParagraph paragraph = document.createParagraph();
  CTBookmark bookmark = paragraph.getCTP().addNewBookmarkStart();
  bookmark.setName(anchor);
  bookmark.setId(BigInteger.valueOf(bookmarkId));
  XWPFRun run = paragraph.createRun();
  paragraph.getCTP().addNewBookmarkEnd().setId(BigInteger.valueOf(bookmarkId));
  return paragraph;
 }

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument();

  String anchor = "hyperlink_target"; 
  int bookmarkId = 0;

  XWPFParagraph paragraph = document.createParagraph();
  XWPFRun run = paragraph.createRun();
  run.setText("This is a text paragraph having ");

  //create hyperlink run
  XWPFHyperlinkRun hyperlinkrun = createHyperlinkRunToAnchor(paragraph, anchor);
  hyperlinkrun.setText("a link to an bookmark anchor");
  hyperlinkrun.setColor("0000FF");
  hyperlinkrun.setUnderline(UnderlinePatterns.SINGLE);

  run = paragraph.createRun();
  run.setText(" in it.");

  //some empty paragraphs
  for (int i = 0; i < 10; i++) {
   paragraph = document.createParagraph();
  }

  //create bookmarked paragraph as the hyperlink target
  paragraph = createBookmarkedParagraph(document, anchor, bookmarkId++);
  run = paragraph.getRuns().get(0);
  run.setText("This is the target.");

  FileOutputStream out = new FileOutputStream("CreateWordHyperlinkBookmark.docx");
  document.write(out);
  out.close();
  document.close();

 }
}