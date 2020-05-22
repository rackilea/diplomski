import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.SpreadsheetVersion;

import org.apache.poi.xddf.usermodel.chart.*;

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
  Row row;
  Cell cell;

  List<XDDFChartData> chartDataList = chart.getChartSeries();
  XDDFChartData chartData = chartDataList.get(0);

  List<XDDFChartData.Series> seriesList = chartData.getSeries();
  int ser = 0;
  for (XDDFChartData.Series series : seriesList) {
   XDDFDataSource categoryData = series.getCategoryData();
   AreaReference catReference = new AreaReference(categoryData.getDataRangeReference(), SpreadsheetVersion.EXCEL2007);
   CellReference firstCatCell = catReference.getFirstCell();
   CellReference lastCatCell = catReference.getLastCell();
   if (firstCatCell.getCol() == lastCatCell.getCol()) {
    int col = firstCatCell.getCol();
    int lastRow = lastCatCell.getRow();
    row = sheet.getRow(lastRow+1); if (row == null) row = sheet.createRow(lastRow+1);
    cell = row.getCell(col); if (cell == null) cell = row.createCell(col);
    cell.setCellValue(month);

    XDDFDataSource<String> category = XDDFDataSourcesFactory.fromStringCellRange(
                                       sheet, 
                                       new CellRangeAddress(firstCatCell.getRow(), lastRow+1, col, col));

    XDDFNumericalDataSource valuesData = series.getValuesData();
    AreaReference numReference = new AreaReference(valuesData.getDataRangeReference(), SpreadsheetVersion.EXCEL2007);
    CellReference firstNumCell = numReference.getFirstCell();
    CellReference lastNumCell = numReference.getLastCell();
    if (lastNumCell.getRow() == lastRow && firstNumCell.getCol() == lastNumCell.getCol()) {
     col = firstNumCell.getCol();
     row = sheet.getRow(lastRow+1); if (row == null) row = sheet.createRow(lastRow+1);
     cell = row.getCell(col); if (cell == null) cell = row.createCell(col);
     if (ser < seriesData.length) cell.setCellValue(seriesData[ser]);
     else cell.setCellValue(0); // Here we need set 0 where it not should be needed.

     XDDFNumericalDataSource<Double> values = XDDFDataSourcesFactory.fromNumericCellRange(
                                               sheet, 
                                               new CellRangeAddress(firstNumCell.getRow(), lastRow+1, col, col));

     series.replaceData(category, values);
    }
   }
   ser++;
  }
  chart.plot(chartData);
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