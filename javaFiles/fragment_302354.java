import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;

public class CreateWordEnglishAndChinese {

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument();

  XWPFParagraph paragraph = document.createParagraph();
  if (paragraph.getCTP().getPPr() == null) paragraph.getCTP().addNewPPr();
  if (paragraph.getCTP().getPPr().getAutoSpaceDE() == null) paragraph.getCTP().getPPr().addNewAutoSpaceDE();
  paragraph.getCTP().getPPr().getAutoSpaceDE().setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff.OFF);
  if (paragraph.getCTP().getPPr().getAutoSpaceDN() == null) paragraph.getCTP().getPPr().addNewAutoSpaceDN();
  paragraph.getCTP().getPPr().getAutoSpaceDN().setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff.OFF);

  XWPFRun run = paragraph.createRun();
  run.setText("12H型:Type 12H");

  FileOutputStream out = new FileOutputStream("CreateWordEnglishAndChinese.docx");
  document.write(out);
  out.close();
  document.close();

 }
}