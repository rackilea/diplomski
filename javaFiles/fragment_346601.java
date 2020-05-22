import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.SpreadsheetVersion;

import org.openxmlformats.schemas.drawingml.x2006.chart.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.util.List;

class ExcelChangeChartDataSource {

 static XSSFChart getChartWithTitle(XSSFSheet sheet, String wantedTitle) {
  if (sheet == null || wantedTitle == null) return null;
  XSSFDrawing drawing = sheet.createDrawingPatriarch();
  List<XSSFChart> charts = drawing.getCharts();
  for (XSSFChart chart : charts) {
   String title = chart.getTitleText().toString();
   if (wantedTitle.equals(title)) return chart;
  }
  return null;
 }

 static void addMonthDataToChart(XSSFSheet sheet, XSSFChart chart, String month, Double[] seriesData) {
  CTChart ctChart = chart.getCTChart();
  CTPlotArea ctPlotArea = ctChart.getPlotArea();
  List<CTLineSer> ctLineSerList = ctPlotArea.getLineChartArray(0).getSerList();

  Row row;
  Cell cell;
  int ser = 0;
  for (CTLineSer ctLineSer : ctLineSerList) {

   CTAxDataSource cttAxDataSource = ctLineSer.getCat();
   CTStrRef ctStrRef = cttAxDataSource.getStrRef();

   AreaReference catReference = new AreaReference(ctStrRef.getF(), SpreadsheetVersion.EXCEL2007);
   CellReference firstCatCell = catReference.getFirstCell();
   CellReference lastCatCell = catReference.getLastCell();
   if (firstCatCell.getCol() == lastCatCell.getCol()) {
    int col = firstCatCell.getCol();
    int lastRow = lastCatCell.getRow();
    row = sheet.getRow(lastRow+1); if (row == null) row = sheet.createRow(lastRow+1);
    cell = row.getCell(col); if (cell == null) cell = row.createCell(col);
    cell.setCellValue(month);

    ctStrRef.setF(new AreaReference(
                  firstCatCell, 
                  new CellReference(lastCatCell.getSheetName(), lastRow+1, col, true, true), 
                  SpreadsheetVersion.EXCEL2007).formatAsString()
                 );

    CTNumDataSource ctNumDataSource = ctLineSer.getVal();
    CTNumRef ctNumRef = ctNumDataSource.getNumRef();

    AreaReference numReference = new AreaReference(ctNumRef.getF(), SpreadsheetVersion.EXCEL2007);
    CellReference firstNumCell = numReference.getFirstCell();
    CellReference lastNumCell = numReference.getLastCell();
    if (lastNumCell.getRow() == lastRow && firstNumCell.getCol() == lastNumCell.getCol()) {
     col = firstNumCell.getCol();
     row = sheet.getRow(lastRow+1); if (row == null) row = sheet.createRow(lastRow+1);
     cell = row.getCell(col); if (cell == null) cell = row.createCell(col);
     if (ser < seriesData.length) cell.setCellValue(seriesData[ser]);

     ctNumRef.setF(new AreaReference(
                   firstNumCell, 
                   new CellReference(lastNumCell.getSheetName(), lastRow+1, col, true, true), 
                   SpreadsheetVersion.EXCEL2007).formatAsString()
                  );
    }
   }
   ser++;
  }
 }

 public static void main(String[] args) throws Exception {

  XSSFWorkbook workbook = (XSSFWorkbook)WorkbookFactory.create(new FileInputStream("WorkbookWithChart.xlsx"));

  XSSFSheet sheet = workbook.getSheetAt(0);

  XSSFChart chart = getChartWithTitle(sheet, "Z-Acceleration"); 

  if (chart != null) {
   addMonthDataToChart(sheet, chart, "Apr", new Double[]{7d,3d,5d});
   addMonthDataToChart(sheet, chart, "Mai", new Double[]{2d,6d,8d});
   addMonthDataToChart(sheet, chart, "Jun", new Double[]{1d,9d,4d});
   addMonthDataToChart(sheet, chart, "Jul", new Double[]{5d,6d});
  }

  FileOutputStream out = new FileOutputStream("WorkbookWithChartNew.xlsx");
  workbook.write(out);
  out.close();
  workbook.close();
 }
}