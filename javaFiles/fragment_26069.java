import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.ss.util.CellRangeAddress;

public class CreateExcelScatterChart {

 public static void main(String[] args) throws Exception {

  Workbook wb = new XSSFWorkbook();
  Sheet sheet = wb.createSheet("chart");
  final int NUM_OF_ROWS = 2;
  final int NUM_OF_COLUMNS = 20;

  Row row;
  Cell cell;
  //x values
  for (int rowIndex = 0; rowIndex < 1; rowIndex++) {
    row = sheet.createRow((short) rowIndex);
    for (int colIndex = 0; colIndex < NUM_OF_COLUMNS; colIndex++) {
      cell = row.createCell((short) colIndex);
      cell.setCellValue(4*colIndex * (rowIndex + 1));
    }
  }
  // y values
  for (int rowIndex = 1; rowIndex < NUM_OF_ROWS; rowIndex++) {
    row = sheet.createRow((short) rowIndex);
    for (int colIndex = 0; colIndex < NUM_OF_COLUMNS; colIndex++) {
      cell = row.createCell((short) colIndex);
      cell.setCellValue(Math.sin(Math.PI*colIndex/10*2));
    }
  }

  Drawing<?> drawing = sheet.createDrawingPatriarch();
  ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 3, 13, 20);

  Chart chart = drawing.createChart(anchor);
  ChartLegend legend = chart.getOrCreateLegend();
  legend.setPosition(LegendPosition.TOP_RIGHT);

  ScatterChartData data = chart.getChartDataFactory().createScatterChartData();

  ValueAxis bottomAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.BOTTOM);
  ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);

  leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
  bottomAxis.setCrosses(AxisCrosses.AUTO_ZERO);
  for (int i = 0; i < NUM_OF_COLUMNS; i++) {
    ChartDataSource<Number> xs = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(0, 0, i, i));
    ChartDataSource<Number> ys = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 1, i, i));

    ScatterChartSeries chartSerie = data.addSerie(xs, ys);
    chartSerie.setTitle("My Title " + i);
  }

  chart.plot(data, bottomAxis, leftAxis);

  //set line properties of first scatter chart data serie to no fill:
  CTScatterSer[] scatterChartSeries = ((XSSFChart) chart).getCTChart().getPlotArea().getScatterChartArray(0).getSerArray();
  for (int i = 0; i < scatterChartSeries.length; i++) {
    scatterChartSeries[i].addNewSpPr().addNewLn().addNewNoFill();
  }



  wb.write(new FileOutputStream("CreateExcelScatterChart.xlsx"));
  wb.close();

 }

}