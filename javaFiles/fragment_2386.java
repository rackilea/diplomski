import java.io.*;

import org.apache.poi.*;
import org.apache.poi.xslf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.util.*;
import org.apache.poi.openxml4j.opc.*;
import static org.apache.poi.POIXMLTypeLoader.DEFAULT_XML_OPTIONS;

import org.apache.xmlbeans.*;

import org.openxmlformats.schemas.drawingml.x2006.chart.*;
import org.openxmlformats.schemas.drawingml.x2006.main.*;
import org.openxmlformats.schemas.presentationml.x2006.main.*;

import javax.xml.namespace.QName;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.regex.Pattern;

import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;

public class CreatePPTXChartsXSSFWb {

 public CreatePPTXChartsXSSFWb() throws Exception {
  XMLSlideShow slideShow = new XMLSlideShow();
  XSLFSlide slide = slideShow.createSlide();

  MyXSLFChartShape myXSLFChartShape = createXSLFChart(slide);
  myXSLFChartShape.setAnchor(new Rectangle(50,100,300,300));

  drawPieChart(myXSLFChartShape);

  myXSLFChartShape = createXSLFChart(slide);
  myXSLFChartShape.setAnchor(new Rectangle(370,100,300,300));

  drawBarChart(myXSLFChartShape);

  FileOutputStream out = new FileOutputStream("CreatePPTXChartsXSSFWb.pptx");
  slideShow.write(out);
  out.close();
 }

 //a method for creating the chart XML document /ppt/charts/chart*.xml in the *.pptx ZIP archive
 //and creating a MyXSLFChartShape as slide shape  
 public MyXSLFChartShape createXSLFChart(XSLFSlide slide) throws Exception {

  OPCPackage oPCPackage = slide.getSlideShow().getPackage();
  int chartCount = oPCPackage.getPartsByName(Pattern.compile("/ppt/charts/chart.*")).size() + 1;
  PackagePartName partName = PackagingURIHelper.createPartName("/ppt/charts/chart" + chartCount + ".xml");
  PackagePart part = oPCPackage.createPart(partName, "application/vnd.openxmlformats-officedocument.drawingml.chart+xml");

  MyXSLFChart myXSLFChart = new MyXSLFChart(part);
  MyXSLFChartShape myXSLFChartShape = new MyXSLFChartShape(slide, myXSLFChart);

  return myXSLFChartShape;
 }

 public void drawPieChart(MyXSLFChartShape myXSLFChartShape) {

  XSSFWorkbook workbook = myXSLFChartShape.getMyXSLFChart().getXSLFXSSFWorkbook().getXSSFWorkbook();
  XSSFSheet sheet = workbook.getSheetAt(0);
  sheet.createRow(0).createCell(0).setCellValue("Cat");
  sheet.getRow(0).createCell(1).setCellValue("Val");
  for (int r = 1; r < 4; r++) {
   sheet.createRow(r).createCell(0).setCellValue("Cat" + r);
   sheet.getRow(r).createCell(1).setCellValue(10*r);
  }

  CTChartSpace chartSpace = myXSLFChartShape.getMyXSLFChart().getChartSpace();
  CTPieChart cTPieChart = chartSpace.addNewChart().addNewPlotArea().addNewPieChart();
  cTPieChart.addNewVaryColors().setVal(true);
  CTPieSer cTPieSer = cTPieChart.addNewSer();
  cTPieSer.addNewIdx().setVal(0);
  CTStrRef cTStrRef = cTPieSer.addNewTx().addNewStrRef();
  cTStrRef.setF("Sheet0!$B$1");
  cTStrRef.addNewStrCache().addNewPtCount().setVal(1);
  CTStrVal cTStrVal = cTStrRef.getStrCache().addNewPt();
  cTStrVal.setIdx(0);
  cTStrVal.setV("Val");

  cTStrRef = cTPieSer.addNewCat().addNewStrRef();
  cTStrRef.setF("Sheet0!$A$2:$A$4");

  cTStrRef.addNewStrCache().addNewPtCount().setVal(3);
  for (int r = 1; r < 4; r++) { 
   cTStrVal = cTStrRef.getStrCache().addNewPt();
   cTStrVal.setIdx(r-1);
   cTStrVal.setV("Cat" + r);
  }

  CTNumRef cTNumRef = cTPieSer.addNewVal().addNewNumRef();
  cTNumRef.setF("Sheet0!$B$2:$B$4");

  cTNumRef.addNewNumCache().addNewPtCount().setVal(3);
  for (int r = 1; r < 4; r++) { 
   CTNumVal cTNumVal = cTNumRef.getNumCache().addNewPt();
   cTNumVal.setIdx(r-1);
   cTNumVal.setV("" + (10*r));
  }
 }

 public void drawBarChart(MyXSLFChartShape myXSLFChartShape) {

  XSSFWorkbook workbook = myXSLFChartShape.getMyXSLFChart().getXSLFXSSFWorkbook().getXSSFWorkbook();
  XSSFSheet sheet = workbook.getSheetAt(0);
  sheet.createRow(0);
  for (int c = 1; c < 4; c++) { 
   sheet.getRow(0).createCell(c).setCellValue("Cat" + c);
  }
  for (int r = 1; r < 5; r++) {
   sheet.createRow(r).createCell(0).setCellValue("Val" + r);
   for (int c = 1; c < 4; c++) { 
    sheet.getRow(r).createCell(c).setCellValue((10+r)*c);
   }
  }

  CTChartSpace chartSpace = myXSLFChartShape.getMyXSLFChart().getChartSpace();
  CTChart cTChart = chartSpace.addNewChart();
  CTPlotArea cTPlotArea = cTChart.addNewPlotArea();
  CTBarChart cTBarChart = cTPlotArea.addNewBarChart();
  cTBarChart.addNewVaryColors().setVal(true);
  cTBarChart.addNewBarDir().setVal(STBarDir.COL);

  for (int r = 1; r < 5; r++) {
   CTBarSer cTBarSer = cTBarChart.addNewSer();
   CTStrRef cTStrRef = cTBarSer.addNewTx().addNewStrRef();
   cTStrRef.setF("Sheet0!$A$" + (r+1));
   cTStrRef.addNewStrCache().addNewPtCount().setVal(1);
   CTStrVal cTStrVal = cTStrRef.getStrCache().addNewPt();
   cTStrVal.setIdx(0);
   cTStrVal.setV("Val" + r);
   cTBarSer.addNewIdx().setVal(r-1);

   CTAxDataSource cttAxDataSource = cTBarSer.addNewCat();
   cTStrRef = cttAxDataSource.addNewStrRef();
   cTStrRef.setF("Sheet0!$B$1:$D$1");   
   cTStrRef.addNewStrCache().addNewPtCount().setVal(3);
   for (int c = 1; c < 4; c++) { 
    cTStrVal = cTStrRef.getStrCache().addNewPt();
    cTStrVal.setIdx(c-1);
    cTStrVal.setV("Cat" + c);
   }

   CTNumDataSource ctNumDataSource = cTBarSer.addNewVal();
   CTNumRef cTNumRef = ctNumDataSource.addNewNumRef();
   cTNumRef.setF("Sheet0!$B$" + (r+1) + ":$D$" + (r+1));
   cTNumRef.addNewNumCache().addNewPtCount().setVal(3);
   for (int c = 1; c < 4; c++) { 
    CTNumVal cTNumVal = cTNumRef.getNumCache().addNewPt();
    cTNumVal.setIdx(c-1);
    cTNumVal.setV("" + ((10+r)*c));
   }
  } 

  //telling the BarChart that it has axes and giving them Ids
  cTBarChart.addNewAxId().setVal(123456);
  cTBarChart.addNewAxId().setVal(123457);

  //cat axis
  CTCatAx cTCatAx = cTPlotArea.addNewCatAx(); 
  cTCatAx.addNewAxId().setVal(123456); //id of the cat axis
  CTScaling cTScaling = cTCatAx.addNewScaling();
  cTScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
  cTCatAx.addNewDelete().setVal(false);
  cTCatAx.addNewAxPos().setVal(STAxPos.B);
  cTCatAx.addNewCrossAx().setVal(123457); //id of the val axis
  cTCatAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);

  //val axis
  CTValAx cTValAx = cTPlotArea.addNewValAx(); 
  cTValAx.addNewAxId().setVal(123457); //id of the val axis
  cTScaling = cTValAx.addNewScaling();
  cTScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
  cTValAx.addNewDelete().setVal(false);
  cTValAx.addNewAxPos().setVal(STAxPos.L);
  cTValAx.addNewCrossAx().setVal(123456); //id of the cat axis
  cTValAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);

  //legend
  CTLegend cTLegend = cTChart.addNewLegend();
  cTLegend.addNewLegendPos().setVal(STLegendPos.B);
  cTLegend.addNewOverlay().setVal(false);

 }


 public static void main(String[] args) throws Exception {
  CreatePPTXChartsXSSFWb createPPTXCharts = new CreatePPTXChartsXSSFWb();
 }

 //a class for providing a MyXSLFChartShape
 private class MyXSLFChartShape {
  private CTGraphicalObjectFrame _graphicalObjectFrame;
  private XSLFSlide slide;
  private MyXSLFChart myXSLFChart;

  MyXSLFChartShape(XSLFSlide slide, MyXSLFChart myXSLFChart) throws Exception {

   String rId = "rId" + (slide.getRelationParts().size()+1);
   slide.addRelation(rId, XSLFRelation.CHART, myXSLFChart);

   long cNvPrId = 1;
   String cNvPrName = "MyChart";
   int cNvPrNameCount = 1;
   for (CTGraphicalObjectFrame currGraphicalObjectFrame : slide.getXmlObject().getCSld().getSpTree().getGraphicFrameList()) {
    if (currGraphicalObjectFrame.getNvGraphicFramePr() != null) {
     if (currGraphicalObjectFrame.getNvGraphicFramePr().getCNvPr() != null) {
      cNvPrId++;
      if (currGraphicalObjectFrame.getNvGraphicFramePr().getCNvPr().getName().startsWith(cNvPrName)) {
       cNvPrNameCount++;
      }
     }
    }
   }

   CTGraphicalObjectFrame graphicalObjectFrame = slide.getXmlObject().getCSld().getSpTree().addNewGraphicFrame();
   CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual = graphicalObjectFrame.addNewNvGraphicFramePr();
   cTGraphicalObjectFrameNonVisual.addNewCNvGraphicFramePr();
   cTGraphicalObjectFrameNonVisual.addNewNvPr();

   CTNonVisualDrawingProps cTNonVisualDrawingProps = cTGraphicalObjectFrameNonVisual.addNewCNvPr();
   cTNonVisualDrawingProps.setId(cNvPrId);
   cTNonVisualDrawingProps.setName("MyChart" + cNvPrNameCount);

   CTGraphicalObject graphicalObject = graphicalObjectFrame.addNewGraphic();
   CTGraphicalObjectData graphicalObjectData = CTGraphicalObjectData.Factory.parse(
     "<c:chart xmlns:c=\"http://schemas.openxmlformats.org/drawingml/2006/chart\" "
    +"xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" "
    +"r:id=\"" + rId + "\"/>"
   );
   graphicalObjectData.setUri("http://schemas.openxmlformats.org/drawingml/2006/chart");
   graphicalObject.setGraphicData(graphicalObjectData);

   _graphicalObjectFrame = graphicalObjectFrame;
   this.slide = slide;
   this.myXSLFChart = myXSLFChart;

   this.setAnchor(new Rectangle());
  }

  private void setAnchor(Rectangle2D anchor) {
   CTTransform2D xfrm = (_graphicalObjectFrame.getXfrm() != null) ? _graphicalObjectFrame.getXfrm() : _graphicalObjectFrame.addNewXfrm();
   CTPoint2D off = xfrm.isSetOff() ? xfrm.getOff() : xfrm.addNewOff();
   long x = Units.toEMU(anchor.getX());
   long y = Units.toEMU(anchor.getY());
   off.setX(x);
   off.setY(y);
   CTPositiveSize2D ext = xfrm.isSetExt() ? xfrm.getExt() : xfrm.addNewExt();
   long cx = Units.toEMU(anchor.getWidth());
   long cy = Units.toEMU(anchor.getHeight());
   ext.setCx(cx);
   ext.setCy(cy);
  }

  private MyXSLFChart getMyXSLFChart() {
   return myXSLFChart;
  }
 }

 //a wrapper class for the ChartSpaceDocument /ppt/charts/chart*.xml in the *.pptx ZIP archive  
 private class MyXSLFChart extends POIXMLDocumentPart {

  private CTChartSpace chartSpace;
  private MyXSLFXSSFWorkbook myXSLFXSSFWorkbook;

  private MyXSLFChart(PackagePart part) throws Exception {
   super(part);

   OPCPackage oPCPackage = part.getPackage();
   int chartCount = oPCPackage.getPartsByName(Pattern.compile("/ppt/embeddings/.*.xlsx")).size() + 1;
   PackagePartName partName = PackagingURIHelper.createPartName("/ppt/embeddings/Microsoft_Excel_Worksheet" + chartCount + ".xlsx");
   PackagePart xlsxpart = oPCPackage.createPart(partName, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

   myXSLFXSSFWorkbook = new MyXSLFXSSFWorkbook(xlsxpart);

   String rId = "rId" + (this.getRelationParts().size()+1);
   XSLFXSSFRelation xSLFXSSFRelationPACKAGE = new XSLFXSSFRelation(
    "http://schemas.openxmlformats.org/officeDocument/2006/relationships/package");

   this.addRelation(rId, xSLFXSSFRelationPACKAGE, myXSLFXSSFWorkbook);

   chartSpace = ChartSpaceDocument.Factory.newInstance().addNewChartSpace();
   CTExternalData cTExternalData = chartSpace.addNewExternalData();
   cTExternalData.setId(rId);
   //cTExternalData.addNewAutoUpdate().setVal(true);
  }

  private CTChartSpace getChartSpace() {
   return chartSpace;
  }

  private MyXSLFXSSFWorkbook getXSLFXSSFWorkbook() {
   return myXSLFXSSFWorkbook;
  }

  @Override
  protected void commit() throws IOException {
   XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
   xmlOptions.setSaveSyntheticDocumentElement(new QName(CTChartSpace.type.getName().getNamespaceURI(), "chartSpace", "c"));
   PackagePart part = getPackagePart();
   OutputStream out = part.getOutputStream();
   chartSpace.save(out, xmlOptions);
   out.close();
  }

 }

 //a wrapper class for the XSSFWorkbook /ppt/embeddings/Microsoft_Excel_Worksheet*.xlsx in the *.pptx ZIP archive  
 private class MyXSLFXSSFWorkbook extends POIXMLDocumentPart {

  private XSSFWorkbook workbook;

  private MyXSLFXSSFWorkbook(PackagePart part) throws Exception {
   super(part);
   workbook = new XSSFWorkbook();
   XSSFSheet sheet = workbook.createSheet();
  }

  private XSSFWorkbook getXSSFWorkbook() {
   return workbook;
  }

  @Override
  protected void commit() throws IOException {
   PackagePart part = getPackagePart();
   OutputStream out = part.getOutputStream();
   workbook.write(out);
   workbook.close();
   out.close();
  }
 }

 //a class to note the relations
 private class XSLFXSSFRelation extends POIXMLRelation {
  private XSLFXSSFRelation(String rel) {
   super(null, rel, null);
  }
 }
}