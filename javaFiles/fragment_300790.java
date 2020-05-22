import java.io.File;
import java.io.FileOutputStream;

import java.math.BigInteger;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;

public class CreateWordTableMerge {

 static void mergeCellVertically(XWPFTable table, int col, int fromRow, int toRow) {
  for(int rowIndex = fromRow; rowIndex <= toRow; rowIndex++){
   XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
   CTVMerge vmerge = CTVMerge.Factory.newInstance();
   if(rowIndex == fromRow){
    // The first merged cell is set with RESTART merge value
    vmerge.setVal(STMerge.RESTART);
   } else {
    // Cells which join (merge) the first one, are set with CONTINUE
    vmerge.setVal(STMerge.CONTINUE);
    // and the content should be removed
    for (int i = cell.getParagraphs().size(); i > 0; i--) {
     cell.removeParagraph(0);
    }
    cell.addParagraph();
   }
   // Try getting the TcPr. Not simply setting an new one every time.
   CTTcPr tcPr = cell.getCTTc().getTcPr();
   if (tcPr != null) {
    tcPr.setVMerge(vmerge);
   } else {
    // only set an new TcPr if there is not one already
    tcPr = CTTcPr.Factory.newInstance();
    tcPr.setVMerge(vmerge);
    cell.getCTTc().setTcPr(tcPr);
   }
  }
 }

 static void mergeCellHorizontally(XWPFTable table, int row, int fromCol, int toCol) {
  for(int colIndex = fromCol; colIndex <= toCol; colIndex++){
   XWPFTableCell cell = table.getRow(row).getCell(colIndex);
   CTHMerge hmerge = CTHMerge.Factory.newInstance();
   if(colIndex == fromCol){
    // The first merged cell is set with RESTART merge value
    hmerge.setVal(STMerge.RESTART);
   } else {
    // Cells which join (merge) the first one, are set with CONTINUE
    hmerge.setVal(STMerge.CONTINUE);
    // and the content should be removed
    for (int i = cell.getParagraphs().size(); i > 0; i--) {
     cell.removeParagraph(0);
    }
    cell.addParagraph();
   }
   // Try getting the TcPr. Not simply setting an new one every time.
   CTTcPr tcPr = cell.getCTTc().getTcPr();
   if (tcPr != null) {
    tcPr.setHMerge(hmerge);
   } else {
    // only set an new TcPr if there is not one already
    tcPr = CTTcPr.Factory.newInstance();
    tcPr.setHMerge(hmerge);
    cell.getCTTc().setTcPr(tcPr);
   }
  }
 }

 public static void main(String[] args) throws Exception {

  XWPFDocument document= new XWPFDocument();

  XWPFParagraph paragraph = document.createParagraph();
  XWPFRun run=paragraph.createRun();  
  run.setText("The table:");

  //create table
  XWPFTable table = document.createTable(3,5);

  for (int row = 0; row < 3; row++) {
   for (int col = 0; col < 5; col++) {
    table.getRow(row).getCell(col).setText("row " + row + ", col " + col);
   }
  }


  //create CTTblGrid for this table with widths of the 5 columns. 
  //necessary for Libreoffice/Openoffice to accept the column widths.
  //values are in unit twentieths of a point (1/1440 of an inch)
  //first column = 1 inches width
  table.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(1*1440));
  //other columns (2 in this case) also each 1 inches width
  for (int col = 1 ; col < 5; col++) {
   table.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(1*1440));
  }


  //create and set column widths for all columns in all rows
  //most examples don't set the type of the CTTblWidth but this
  //is necessary for working in all office versions
  for (int col = 0; col < 5; col++) {
   CTTblWidth tblWidth = CTTblWidth.Factory.newInstance();
   tblWidth.setW(BigInteger.valueOf(1*1440));
   tblWidth.setType(STTblWidth.DXA);
   for (int row = 0; row < 3; row++) {
    CTTcPr tcPr = table.getRow(row).getCell(col).getCTTc().getTcPr();
    if (tcPr != null) {
     tcPr.setTcW(tblWidth);
    } else {
     tcPr = CTTcPr.Factory.newInstance();
     tcPr.setTcW(tblWidth);
     table.getRow(row).getCell(col).getCTTc().setTcPr(tcPr);
    }
   }
  }

  //using the merge methods
  mergeCellVertically(table, 0, 0, 1); 
  mergeCellHorizontally(table, 1, 2, 3); 
  mergeCellHorizontally(table, 2, 1, 4); 

  paragraph = document.createParagraph();

  FileOutputStream out = new FileOutputStream("create_table.docx"); 
  document.write(out);
  out.close();

  System.out.println("create_table.docx written successully");
 }
}