import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFDrawing;

import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlCursor;
import javax.xml.namespace.QName;

public class FormatSunBurstChart {

 private static void setDataPointColor(XmlObject series, int number, String colorHex) {
  XmlCursor cursor = series.newCursor();
  cursor.toLastChild();
  cursor.beginElement(new QName("http://schemas.microsoft.com/office/drawing/2014/chartex", "dataPt", "cx"));
  cursor.insertAttributeWithValue("idx", "" + number);
  cursor.beginElement(new QName("http://schemas.microsoft.com/office/drawing/2014/chartex", "spPr", "cx"));
  cursor.beginElement(new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "solidFill", "a"));
  cursor.beginElement(new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "srgbClr", "a"));
  cursor.insertAttributeWithValue("val", colorHex);

  cursor.dispose();
 }

 public static void main(String[] args) {
  try {
   XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("ChartExample.xlsx"));
   XSSFSheet sheet = workbook.getSheetAt(0);
   System.out.println("Loaded sheet is " + sheet.getSheetName());
   XSSFDrawing drawing = sheet.getDrawingPatriarch();
   if (drawing != null) {
    for (POIXMLDocumentPart dpart : drawing.getRelations()) {
     PackagePart ppart = dpart.getPackagePart();
     if ("application/vnd.ms-office.chartex+xml".equals(ppart.getContentType())) {
      XSSFChartEx xssfChartEx = new XSSFChartEx(ppart);
      String rId = drawing.getRelationId(dpart);
      drawing.addRelation(
       rId, 
       new XSSFChartExRelation(
        "application/vnd.ms-office.chartex+xml",
        "http://schemas.microsoft.com/office/2014/relationships/chartEx",
        "/xl/charts/chartEx#.xml"),
       xssfChartEx
      );
      XmlObject series = xssfChartEx.getSeries(0);
      setDataPointColor(series, 1, "FF0000");
      setDataPointColor(series, 2, "FFFF00");
      setDataPointColor(series, 3, "00FF00");
      setDataPointColor(series, 14, "FFFF00");
      setDataPointColor(series, 16, "00FF00");
      setDataPointColor(series, 18, "00FF00");
      setDataPointColor(series, 19, "FF0000");
      setDataPointColor(series, 20, "00FF00");
System.out.println(series);
     }
    }
   }
   FileOutputStream out = new FileOutputStream("ChartExampleChanged.xlsx");
   workbook.write(out);
   workbook.close();
   out.close();
  } catch (Exception e) {
   e.printStackTrace();
  }
 }

 private static class XSSFChartEx extends POIXMLDocumentPart {

  private XmlObject chartExXmlObject;

  private XSSFChartEx(PackagePart part) throws Exception {
   super(part);
   chartExXmlObject = XmlObject.Factory.parse(part.getInputStream());
  }

  private XmlObject getChartExXmlObject() {
   return chartExXmlObject;
  }

  private XmlObject getSeries(int number) {
   XmlObject[] result = chartExXmlObject.selectPath(
    "declare namespace cx='http://schemas.microsoft.com/office/drawing/2014/chartex' " +
    ".//cx:chart/cx:plotArea/cx:plotAreaRegion/cx:series"
   );
   return result[number];
  }

  @Override
  protected void commit() throws IOException {
   PackagePart part = getPackagePart();
   OutputStream out = part.getOutputStream();
   chartExXmlObject.save(out);
   out.close();
  }
 }

 private static class XSSFChartExRelation extends POIXMLRelation {
  private XSSFChartExRelation(String type, String rel, String defaultName) {
   super(type, rel, defaultName);
  }
 }
}