import java.io.*;

import org.apache.poi.xwpf.usermodel.*;

import org.apache.poi.util.Units;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;

public class CreateWordImagesBehindAndInFrontText {

 private static CTAnchor getAnchorWithGraphic(CTDrawing drawing /*inline drawing*/ , 
  String drawingDescr, boolean behind) throws Exception {

  CTGraphicalObject graphicalobject = drawing.getInlineArray(0).getGraphic();
  long width = drawing.getInlineArray(0).getExtent().getCx();
  long height = drawing.getInlineArray(0).getExtent().getCy();

  String anchorXML = 
   "<wp:anchor xmlns:wp=\"http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing\" "
  +"simplePos=\"0\" relativeHeight=\"0\" behindDoc=\""+((behind)?1:0)+"\" locked=\"0\" layoutInCell=\"1\" allowOverlap=\"1\">"
  +"<wp:simplePos x=\"0\" y=\"0\"/>"
  +"<wp:positionH relativeFrom=\"column\"><wp:posOffset>0</wp:posOffset></wp:positionH>"
  +"<wp:positionV relativeFrom=\"paragraph\"><wp:posOffset>0</wp:posOffset></wp:positionV>"
  +"<wp:extent cx=\""+width+"\" cy=\""+height+"\"/>"
  +"<wp:effectExtent l=\"0\" t=\"0\" r=\"0\" b=\"0\"/><wp:wrapNone/>"
  +"<wp:docPr id=\"1\" name=\"Drawing 0\" descr=\""+drawingDescr+"\"/><wp:cNvGraphicFramePr/>"
  +"</wp:anchor>";

  drawing = CTDrawing.Factory.parse(anchorXML);
  CTAnchor anchor = drawing.getAnchorArray(0);
  anchor.setGraphic(graphicalobject);
  return anchor;  
 }

 public static void main(String[] args) throws Exception {

  XWPFDocument doc= new XWPFDocument();
  XWPFParagraph paragraph;
  XWPFRun run; 
  InputStream in;
  CTDrawing drawing;
  CTAnchor anchor;

  //default
  paragraph = doc.createParagraph();
  run = paragraph.createRun();
  run.setText("Picture inline with text:");
  in = new FileInputStream("samplePict.jpeg");
  run.addPicture(in, Document.PICTURE_TYPE_JPEG, "samplePict.jpeg", Units.toEMU(150), Units.toEMU(40));
  in.close();  

  paragraph = doc.createParagraph();

  //behind text
  paragraph = doc.createParagraph();
  run = paragraph.createRun();
  in = new FileInputStream("samplePict.jpeg");
  run.addPicture(in, Document.PICTURE_TYPE_JPEG, "samplePict.jpeg", Units.toEMU(150), Units.toEMU(40));
  in.close();  
  drawing = run.getCTR().getDrawingArray(0);

  anchor = getAnchorWithGraphic(drawing, "samplePict.jpeg", true /*behind text*/);

  drawing.setAnchorArray(new CTAnchor[]{anchor});
  drawing.removeInline(0);
  run = paragraph.createRun();
  run.setText("The above picture is behind the text. ");

  paragraph = doc.createParagraph();

  //in front of text
  paragraph = doc.createParagraph();
  run = paragraph.createRun();
  in = new FileInputStream("samplePict.jpeg");
  run.addPicture(in, Document.PICTURE_TYPE_JPEG, "samplePict.jpeg", Units.toEMU(150), Units.toEMU(40));
  in.close();  
  drawing = run.getCTR().getDrawingArray(0);

  anchor = getAnchorWithGraphic(drawing, "samplePict.jpeg", false /*not behind text*/);

  drawing.setAnchorArray(new CTAnchor[]{anchor});
  drawing.removeInline(0);
  run = paragraph.createRun();
  run.setText("The above picture is in front of the text. ");

  paragraph = doc.createParagraph();

  doc.write(new FileOutputStream("CreateWordImagesBehindAndInFrontText.docx"));
  doc.close();

 }
}