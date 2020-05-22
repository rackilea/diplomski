import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.xddf.usermodel.*;
import org.apache.poi.xddf.usermodel.chart.*;

public class StackedBarAndLineChart {

 public static void main(String[] args) throws IOException {
  try (FileInputStream in = new FileInputStream("StackedBarAndLineChart.xlsx"); 
       XSSFWorkbook wb = (XSSFWorkbook)WorkbookFactory.create(in)) {
   XSSFSheet sheet = wb.getSheetAt(0);

   // determine the type of the category axis from it's first category value (value in A2 in this case)
   XDDFDataSource date = null;
   CellType type = CellType.ERROR;
   Row row = sheet.getRow(1);
   if (row != null) {
    Cell cell = row.getCell(0);
    if (cell != null) {
     type = cell.getCellType();
     if (type == CellType.STRING) {   
      date = XDDFDataSourcesFactory.fromStringCellRange(sheet, new CellRangeAddress(1, 10, 0, 0));
     } else  if (type == CellType.NUMERIC) {  
      date = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, 10, 0, 0));
     } else  if (type == CellType.FORMULA) {  
      type = cell.getCachedFormulaResultType();
      if (type == CellType.STRING) {   
       date = XDDFDataSourcesFactory.fromStringCellRange(sheet, new CellRangeAddress(1, 10, 0, 0));
      } else  if (type == CellType.NUMERIC) {  
       date = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, 10, 0, 0));
      }
     }
    }
   }
   if (date != null) { // if no type of category axis found, don't create a chart at all    
    XDDFNumericalDataSource<Double> high = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, 10, 2, 2));
    XDDFNumericalDataSource<Double> medium = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, 10, 3, 3));
    XDDFNumericalDataSource<Double> low = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, 10, 4, 4));
    XDDFNumericalDataSource<Double> category = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, 10, 1, 1));

    XSSFDrawing drawing = sheet.createDrawingPatriarch();
    XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 6, 0, 16, 20);

    XSSFChart chart = drawing.createChart(anchor);
    XDDFChartLegend legend = chart.getOrAddLegend();
    legend.setPosition(LegendPosition.RIGHT);

    // bar chart

    XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
    XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
    leftAxis.setTitle("Number of defects");
    leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

    // category axis crosses the value axis between the strokes and not midpoint the strokes
    leftAxis.setCrossBetween(AxisCrossBetween.BETWEEN);

    XDDFChartData data = chart.createData(ChartTypes.BAR, bottomAxis, leftAxis);
    XDDFChartData.Series series1 = data.addSeries(date, high);
    series1.setTitle("high", new CellReference(sheet.getSheetName(), 0, 2, true, true));
    XDDFChartData.Series series2 = data.addSeries(date, medium);
    series2.setTitle("medium", new CellReference(sheet.getSheetName(), 0, 3, true, true));
    XDDFChartData.Series series3 = data.addSeries(date, low);
    series3.setTitle("low", new CellReference(sheet.getSheetName(), 0, 4, true, true));
    chart.plot(data);

    XDDFBarChartData bar = (XDDFBarChartData) data;
    bar.setBarDirection(BarDirection.COL);

    // looking for "Stacked Bar Chart"? uncomment the following line
    bar.setBarGrouping(BarGrouping.STACKED);

    // correcting the overlap so bars really are stacked and not side by side
    chart.getCTChart().getPlotArea().getBarChartArray(0).addNewOverlap().setVal((byte)100);

    solidFillSeries(data, 0, PresetColor.CORNFLOWER_BLUE);
    solidFillSeries(data, 1, PresetColor.LIGHT_SALMON);
    solidFillSeries(data, 2, PresetColor.LIGHT_GRAY);

    // add data labels
    for (int s = 0 ; s < 3; s++) {
     chart.getCTChart().getPlotArea().getBarChartArray(0).getSerArray(s).addNewDLbls();
     chart.getCTChart().getPlotArea().getBarChartArray(0).getSerArray(s).getDLbls()
      .addNewDLblPos().setVal(org.openxmlformats.schemas.drawingml.x2006.chart.STDLblPos.CTR);
     chart.getCTChart().getPlotArea().getBarChartArray(0).getSerArray(s).getDLbls().addNewShowVal().setVal(true);
     chart.getCTChart().getPlotArea().getBarChartArray(0).getSerArray(s).getDLbls().addNewShowLegendKey().setVal(false);
     chart.getCTChart().getPlotArea().getBarChartArray(0).getSerArray(s).getDLbls().addNewShowCatName().setVal(false);
     chart.getCTChart().getPlotArea().getBarChartArray(0).getSerArray(s).getDLbls().addNewShowSerName().setVal(false);
    }

    // line chart

    // axis must be there but must not be visible
    bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
    bottomAxis.setVisible(false);
    leftAxis = chart.createValueAxis(AxisPosition.LEFT);
    leftAxis.setVisible(false);

    // set correct cross axis
    bottomAxis.crossAxis(leftAxis);
    leftAxis.crossAxis(bottomAxis);

    data = chart.createData(ChartTypes.LINE, bottomAxis, leftAxis);
    XDDFLineChartData.Series series4 = (XDDFLineChartData.Series)data.addSeries(date, category);
    series4.setTitle("total", null);
    series4.setSmooth(false);
    series4.setMarkerStyle(MarkerStyle.STAR);
    chart.plot(data);

    // correct the id and order, must not start 0 again because there are three bar series already
    chart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0).getIdx().setVal(3);
    chart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0).getOrder().setVal(3);

    solidLineSeries(data, 0, PresetColor.YELLOW);

    // add data labels
    chart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0).addNewDLbls();
    chart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0).getDLbls()
     .addNewSpPr().addNewSolidFill().addNewSrgbClr().setVal(new byte[]{(byte)255,(byte)255,0});
    chart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0).getDLbls()
     .addNewDLblPos().setVal(org.openxmlformats.schemas.drawingml.x2006.chart.STDLblPos.CTR);
    chart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0).getDLbls().addNewShowVal().setVal(true);
    chart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0).getDLbls().addNewShowLegendKey().setVal(false);
    chart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0).getDLbls().addNewShowCatName().setVal(false);
    chart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0).getDLbls().addNewShowSerName().setVal(false);
   }

   // Write the output to a file
   try (FileOutputStream fileOut = new FileOutputStream("StackedBarAndLineChartResult.xlsx")) {
    wb.write(fileOut);
   }
  }
 }

 private static void solidFillSeries(XDDFChartData data, int index, PresetColor color) {
  XDDFSolidFillProperties fill = new XDDFSolidFillProperties(XDDFColor.from(color));
  XDDFChartData.Series series = data.getSeries().get(index);
  XDDFShapeProperties properties = series.getShapeProperties();
  if (properties == null) {
   properties = new XDDFShapeProperties();
  }
  properties.setFillProperties(fill);
  series.setShapeProperties(properties);
 }

 private static void solidLineSeries(XDDFChartData data, int index, PresetColor color) {
  XDDFSolidFillProperties fill = new XDDFSolidFillProperties(XDDFColor.from(color));
  XDDFLineProperties line = new XDDFLineProperties();
  line.setFillProperties(fill);
  XDDFChartData.Series series = data.getSeries().get(index);
  XDDFShapeProperties properties = series.getShapeProperties();
  if (properties == null) {
   properties = new XDDFShapeProperties();
  }
  properties.setLineProperties(line);
  series.setShapeProperties(properties);
 }
}