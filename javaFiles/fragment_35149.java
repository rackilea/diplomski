import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.util.Units;

public class CreateWordHeaderWithImage {

 public static void main(String[] args) throws Exception {

  XWPFDocument doc = new XWPFDocument();

  // the body content
  XWPFParagraph paragraph = doc.createParagraph();
  XWPFRun run = paragraph.createRun();  
  run.setText("The Body...");

  // create header
  XWPFHeader header = doc.createHeader(HeaderFooterType.DEFAULT);

  // header's first paragraph
  paragraph = header.getParagraphArray(0);
  if (paragraph == null) paragraph = header.createParagraph();
  paragraph.setAlignment(ParagraphAlignment.CENTER);

  run = paragraph.createRun();

  FileInputStream in = new FileInputStream("samplePict.jpeg");
  run.addPicture(in, Document.PICTURE_TYPE_JPEG, "samplePict.jpeg", Units.toEMU(100), Units.toEMU(50));
  in.close();  

  run.setText("HEADER"); 

  FileOutputStream out = new FileOutputStream("CreateWordHeaderWithImage.docx");
  doc.write(out);
  doc.close();
  out.close();

 }
}