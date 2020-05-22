import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.xwpf.usermodel.*;

import org.apache.poi.util.Units;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;

public class WordInsertPictures {

 private static CTAnchor getAnchorWithGraphic(CTGraphicalObject graphicalobject, 
                                              String drawingDescr, int width, int height,
                                              int left, int top) throws Exception {

  String anchorXML = 
   "<wp:anchor xmlns:wp=\"http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing\" "
  +"simplePos=\"0\" relativeHeight=\"0\" behindDoc=\"1\" locked=\"0\" layoutInCell=\"1\" allowOverlap=\"1\">"
  +"<wp:simplePos x=\"0\" y=\"0\"/>"
  +"<wp:positionH relativeFrom=\"column\"><wp:posOffset>"+left+"</wp:posOffset></wp:positionH>"
  +"<wp:positionV relativeFrom=\"paragraph\"><wp:posOffset>"+top+"</wp:posOffset></wp:positionV>"
  +"<wp:extent cx=\""+width+"\" cy=\""+height+"\"/>"
  +"<wp:effectExtent l=\"0\" t=\"0\" r=\"0\" b=\"0\"/>"
  +"<wp:wrapTight wrapText=\"bothSides\">"
  +"<wp:wrapPolygon edited=\"0\">"
  +"<wp:start x=\"0\" y=\"0\"/>"
  +"<wp:lineTo x=\"0\" y=\"21600\"/>" //Square polygon 21600 x 21600 leads to wrap points in fully width x height
  +"<wp:lineTo x=\"21600\" y=\"21600\"/>"// Why? I don't know. Try & error ;-).
  +"<wp:lineTo x=\"21600\" y=\"0\"/>"
  +"<wp:lineTo x=\"0\" y=\"0\"/>"
  +"</wp:wrapPolygon>"
  +"</wp:wrapTight>"
  +"<wp:docPr id=\"1\" name=\"Drawing 0\" descr=\""+drawingDescr+"\"/><wp:cNvGraphicFramePr/>"
  +"</wp:anchor>";

  CTDrawing drawing = CTDrawing.Factory.parse(anchorXML);
  CTAnchor anchor = drawing.getAnchorArray(0);
  anchor.setGraphic(graphicalobject);
  return anchor;  
 }

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument();
  XWPFParagraph paragraph = document.createParagraph();
  XWPFRun run = paragraph.createRun();

  run.setText("The picture in line: ");

  InputStream in = new FileInputStream("samplePict.jpeg");
  run.addPicture(in, Document.PICTURE_TYPE_JPEG, "samplePict.jpeg", Units.toEMU(100), Units.toEMU(30));
  in.close();  

  run.setText(" text after the picture.");

  paragraph = document.createParagraph();

  run = paragraph.createRun();
  in = new FileInputStream("samplePict.jpeg");
  run.addPicture(in, Document.PICTURE_TYPE_JPEG, "samplePict.jpeg", Units.toEMU(100), Units.toEMU(30));
  in.close();  
  CTDrawing drawing = run.getCTR().getDrawingArray(0);
  CTGraphicalObject graphicalobject = drawing.getInlineArray(0).getGraphic();
  CTAnchor anchor = getAnchorWithGraphic(graphicalobject, "samplePict.jpeg", 
                                         Units.toEMU(100), Units.toEMU(30), 
                                         Units.toEMU(30), Units.toEMU(0));
  drawing.setAnchorArray(new CTAnchor[]{anchor});
  drawing.removeInline(0);

  run = paragraph.createRun();
  run.setText("The previous picture is anchored wrapTight. The previous picture is anchored wrapTight. The previous picture is anchored wrapTight. The previous picture is anchored wrapTight. The previous picture is anchored wrapTight. The previous picture is anchored wrapTight.");

  document.write(new FileOutputStream("WordInsertPictures.docx"));
  document.close();
 }
}