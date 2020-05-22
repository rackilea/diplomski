import java.io.*;

import org.apache.poi.xwpf.usermodel.*;

import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;

public class CreateWordHeaderFooter {

 public static void main(String[] args) throws Exception {

  XWPFDocument doc= new XWPFDocument();

  // the body content
  XWPFParagraph paragraph = doc.createParagraph();
  XWPFRun run=paragraph.createRun();  
  run.setText("The Body:");

  paragraph = doc.createParagraph();
  run=paragraph.createRun();  
  run.setText("Lorem ipsum.... page 1");

  paragraph = doc.createParagraph();
  run=paragraph.createRun();
  run.addBreak(BreakType.PAGE); 
  run.setText("Lorem ipsum.... page 2");

  paragraph = doc.createParagraph();
  run=paragraph.createRun();
  run.addBreak(BreakType.PAGE); 
  run.setText("Lorem ipsum.... page 3");

  // create header-footer
  XWPFHeaderFooterPolicy headerFooterPolicy = doc.getHeaderFooterPolicy();
  if (headerFooterPolicy == null) headerFooterPolicy = doc.createHeaderFooterPolicy();

  // create header start
  XWPFHeader header = headerFooterPolicy.createHeader(XWPFHeaderFooterPolicy.DEFAULT);

  paragraph = header.getParagraphArray(0);
  if (paragraph == null) paragraph = header.createParagraph();
  paragraph.setAlignment(ParagraphAlignment.LEFT);

  run = paragraph.createRun();  
  run.setText("The Header:");

  // create footer start
  XWPFFooter footer = headerFooterPolicy.createFooter(XWPFHeaderFooterPolicy.DEFAULT);

  paragraph = footer.getParagraphArray(0);
  if (paragraph == null) paragraph = footer.createParagraph();
  paragraph.setAlignment(ParagraphAlignment.CENTER);

  run = paragraph.createRun();
  run.setBold(true);  
  run.setText("Page ");

  run = paragraph.createRun();  
  run.setBold(true); 
  run.getCTR().addNewFldChar().setFldCharType(org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType.BEGIN);

  run = paragraph.createRun(); 
  run.setBold(true); 
  run.getCTR().addNewInstrText().setStringValue("PAGE \\* MERGEFORMAT");

  run = paragraph.createRun();  
  run.setBold(true); 
  run.getCTR().addNewFldChar().setFldCharType(org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType.END);

  run = paragraph.createRun();  
  run.setBold(true); 
  run.setText(" of ");

  run = paragraph.createRun();  
  run.setBold(true); 
  run.getCTR().addNewFldChar().setFldCharType(org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType.BEGIN);

  run = paragraph.createRun();  
  run.setBold(true); 
  run.getCTR().addNewInstrText().setStringValue("NUMPAGES \\* MERGEFORMAT");

  run = paragraph.createRun();  
  run.setBold(true); 
  run.getCTR().addNewFldChar().setFldCharType(org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType.END);

  doc.write(new FileOutputStream("CreateWordHeaderFooter.docx"));

 }
}