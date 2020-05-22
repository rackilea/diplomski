import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.util.Units;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;

public class CreateWordTableOfFigures {

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument();

  XWPFParagraph paragraph;
  XWPFRun run;
  InputStream in; 
  CTSimpleField seq;

  paragraph = document.createParagraph();
  run = paragraph.createRun();
  run.setText("Document containing figures");

  paragraph = document.createParagraph();
  run = paragraph.createRun();
  run.setText("Lorem ipsum...");

  //create paragraph containing figure
  paragraph = document.createParagraph();
  paragraph.setSpacingAfter(0); //Set spacing after to 0. So caption will follow immediately under the figure.
  run = paragraph.createRun();
  in = new FileInputStream("samplePict1.png");
  run.addPicture(in, Document.PICTURE_TYPE_PNG, "samplePict1.png", Units.toEMU(150), Units.toEMU(100));
  in.close();  
  paragraph = document.createParagraph(); //caption for figure
  run = paragraph.createRun();
  run.setText("Picture ");
  seq = paragraph.getCTP().addNewFldSimple();
  seq.setInstr("SEQ figure \\* ARABIC"); //This field is important for creating the table of figures then.
  run = paragraph.createRun();
  run.setText(": Description of sample picture 1");

  paragraph = document.createParagraph();
  run = paragraph.createRun();
  run.setText("Lorem ipsum...");

  paragraph = document.createParagraph();
  paragraph.setSpacingAfter(0);
  run = paragraph.createRun();
  in = new FileInputStream("samplePict2.png");
  run.addPicture(in, Document.PICTURE_TYPE_PNG, "samplePict1.png", Units.toEMU(150), Units.toEMU(100));
  in.close();  
  paragraph = document.createParagraph();
  run = paragraph.createRun();
  run.setText("Picture ");
  seq = paragraph.getCTP().addNewFldSimple();
  seq.setInstr("SEQ figure \\* ARABIC");
  run = paragraph.createRun();
  run.setText(": Description of sample picture 2");


  paragraph = document.createParagraph();
  run = paragraph.createRun();
  run.setText("Index of figures:");

  //Create table of figures field. Word will updating that field while opening the file.
  paragraph = document.createParagraph();
  CTSimpleField toc = paragraph.getCTP().addNewFldSimple();
  toc.setInstr("TOC \\c \"figure\" \\* MERGEFORMAT");
  toc.setDirty(STOnOff.TRUE); //set dirty to forcing update


  FileOutputStream out = new FileOutputStream("CreateWordTableOfFigures.docx"); 
  document.write(out);
  document.close();

 }

}