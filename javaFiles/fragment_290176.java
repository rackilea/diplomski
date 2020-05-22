import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STNumberFormat;

import java.util.ArrayList;
import java.util.Arrays;

import java.math.BigInteger;

public class CreateWordSimplestNumberingList {
 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument();

  XWPFParagraph paragraph = document.createParagraph();
  XWPFRun run=paragraph.createRun();  
  run.setText("The list:");

  ArrayList<String> documentList = new ArrayList<String>(
   Arrays.asList(
    new String[] {
     "One",
     "Two",
     "Three"
    }));

  CTAbstractNum cTAbstractNum = CTAbstractNum.Factory.newInstance();
  //Next we set the AbstractNumId. This requires care. 
  //Since we are in a new document we can start numbering from 0. 
  //But if we have an existing document, we must determine the next free number first.
  cTAbstractNum.setAbstractNumId(BigInteger.valueOf(0));

/* Bullet list
  CTLvl cTLvl = cTAbstractNum.addNewLvl();
  cTLvl.addNewNumFmt().setVal(STNumberFormat.BULLET);
  cTLvl.addNewLvlText().setVal("•");
*/

///* Decimal list
  CTLvl cTLvl = cTAbstractNum.addNewLvl();
  cTLvl.addNewNumFmt().setVal(STNumberFormat.DECIMAL);
  cTLvl.addNewLvlText().setVal("%1.");
  cTLvl.addNewStart().setVal(BigInteger.valueOf(1));
//*/

  XWPFAbstractNum abstractNum = new XWPFAbstractNum(cTAbstractNum);

  XWPFNumbering numbering = document.createNumbering();

  BigInteger abstractNumID = numbering.addAbstractNum(abstractNum);

  BigInteger numID = numbering.addNum(abstractNumID);

  for (String string : documentList) {
   paragraph = document.createParagraph();
   paragraph.setNumID(numID);
   run=paragraph.createRun(); 
   run.setText(string); 
  }

  paragraph = document.createParagraph();

  document.write(new FileOutputStream("CreateWordSimplestNumberingList.docx"));
  document.close();

 }
}