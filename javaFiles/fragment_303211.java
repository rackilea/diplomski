import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor;

import java.io.*;

class ReadGroupedShapes {

 public static void main(String[] args) {
  try {

   InputStream inp = new FileInputStream("Shapegroup.xlsx");
   Workbook wb = WorkbookFactory.create(inp);

   Sheet sheet = wb.getSheetAt(0);

   XSSFDrawing drawing = (XSSFDrawing)sheet.getDrawingPatriarch();

   for (XSSFShape shape : drawing.getShapes()) { 
    // possible:   XSSFConnector, XSSFGraphicFrame, XSSFPicture, XSSFShapeGroup, XSSFSimpleShape
    if (shape instanceof XSSFConnector) {
     //System.out.println(((XSSFConnector)shape).getCTConnector());

    } else if (shape instanceof XSSFGraphicFrame) {
     //System.out.println(((XSSFGraphicFrame)shape).getCTGraphicalObjectFrame());

    } else if (shape instanceof XSSFPicture) {
     //System.out.println(((XSSFPicture)shape).getCTPicture());

    } else if (shape instanceof XSSFShapeGroup) { //we have a shape group
     //System.out.println(((XSSFShapeGroup)shape).getCTGroupShape());
     System.out.println("Whole group is anchored upper left:");
     int groupRow = ((XSSFClientAnchor)shape.getAnchor()).getRow1();
     long groupRowDy = ((XSSFClientAnchor)shape.getAnchor()).getDy1();
     System.out.print("Row: " + groupRow);
     System.out.println(" + " + groupRowDy + " EMU");

     int groupCol = ((XSSFClientAnchor)shape.getAnchor()).getCol1();
     long groupColDx = ((XSSFClientAnchor)shape.getAnchor()).getDx1();
     System.out.print("Col: " + groupCol);
     System.out.println(" + " + groupColDx + " EMU");

     //go through all shapes in the group
     for (CTConnector lowLewelConnector : ((XSSFShapeGroup)shape).getCTGroupShape().getCxnSpList()) {
      //System.out.println(lowLewelConnector);
      System.out.println("A connector is in the group:");
      String cxnName = lowLewelConnector.getNvCxnSpPr().getCNvPr().getName();
      String cxnDescr = lowLewelConnector.getNvCxnSpPr().getCNvPr().getDescr();
      System.out.println("Name: " + cxnName + ((!"".equals(cxnDescr)) ? ": " + cxnDescr : ""));
      System.out.println("positioned upper left:");
      long connectorDy = lowLewelConnector.getSpPr().getXfrm().getOff().getY();
      System.out.println("Row " + groupRow + " + " + groupRowDy + " + " + connectorDy + " EMU");

      long connectorDx = lowLewelConnector.getSpPr().getXfrm().getOff().getX();
      System.out.println("Col " + groupCol + " + " + groupColDx + " + " + connectorDx + " EMU");

     }
     for (CTGraphicalObjectFrame lowLewelGrFrame : ((XSSFShapeGroup)shape).getCTGroupShape().getGraphicFrameList()) {
      //System.out.println(lowLewelGrFrame);

     }
     for (CTPicture lowLewelPic : ((XSSFShapeGroup)shape).getCTGroupShape().getPicList()) {
      //System.out.println(lowLewelPic);
      System.out.println("A picture is in the group:");
      String picName = lowLewelPic.getNvPicPr().getCNvPr().getName();
      String picDescr = lowLewelPic.getNvPicPr().getCNvPr().getDescr();
      System.out.println("Name: " + picName + ((!"".equals(picDescr)) ? ": " + picDescr : ""));
      System.out.println("positioned upper left:");
      long pictDy = lowLewelPic.getSpPr().getXfrm().getOff().getY();
      System.out.println("Row " + groupRow + " + " + groupRowDy + " + " + pictDy + " EMU");

      long pictDx = lowLewelPic.getSpPr().getXfrm().getOff().getX();
      System.out.println("Col " + groupCol + " + " + groupColDx + " + " + pictDx + " EMU");

     }
     for (CTGroupShape lowLewelGroupShape : ((XSSFShapeGroup)shape).getCTGroupShape().getGrpSpList()) {
      //System.out.println(lowLewelGroupShape);

     }
     for (CTShape lowLewelShape : ((XSSFShapeGroup)shape).getCTGroupShape().getSpList()) {
      //System.out.println(lowLewelShape);
      System.out.println("A simple shape is in the group:");
      String spName = lowLewelShape.getNvSpPr().getCNvPr().getName();
      String spDescr = lowLewelShape.getNvSpPr().getCNvPr().getDescr();
      System.out.println("Name: " + spName + ((!"".equals(spDescr)) ? ": " + spDescr : ""));
      System.out.println("positioned upper left:");
      long simpleShapeDy = lowLewelShape.getSpPr().getXfrm().getOff().getY();
      System.out.println("Row " + groupRow + " + " + groupRowDy + " + " + simpleShapeDy + " EMU");

      long simpleShapeDx = lowLewelShape.getSpPr().getXfrm().getOff().getX();
      System.out.println("Col " + groupCol + " + " + groupColDx + " + " + simpleShapeDx + " EMU");

     }

    } else if (shape instanceof XSSFSimpleShape) {
     //System.out.println(((XSSFSimpleShape)shape).getCTShape());

    }
   }


  } catch (InvalidFormatException ifex) {
  } catch (FileNotFoundException fnfex) {
  } catch (IOException ioex) {
  }
 }
}