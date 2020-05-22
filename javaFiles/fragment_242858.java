import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.chart.LegendPosition;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFChartLegend;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFPieChartData;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class PieChart {

  public static void main(String[] args) throws IOException {
    try (XSSFWorkbook wb = new XSSFWorkbook()) {
      XSSFSheet sheet = wb.createSheet("piechart");
      final int NUM_OF_ROWS = 2;
      final int NUM_OF_COLUMNS = 10;

      // Create a row and put some cells in it. Rows are 0 based.
      Row row;
      Cell cell;
      for (int rowIndex = 0; rowIndex < NUM_OF_ROWS; rowIndex++) {
        row = sheet.createRow((short) rowIndex);
        for (int colIndex = 0; colIndex < NUM_OF_COLUMNS; colIndex++) {
          cell = row.createCell((short) colIndex);
          if (rowIndex == 0) cell.setCellValue("Cat " + (colIndex + 1));
          else cell.setCellValue((colIndex + 1) * (rowIndex + 1));
        }
      }

      XSSFDrawing drawing = sheet.createDrawingPatriarch();
      XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 4, 10, 25);

      XSSFChart chart = drawing.createChart(anchor);
      chart.setTitleText("Pie Chart");
      chart.setTitleOverlay(false);
      XDDFChartLegend legend = chart.getOrAddLegend();
      legend.setPosition(LegendPosition.TOP_RIGHT);

      XDDFDataSource<String> cat = XDDFDataSourcesFactory.fromStringCellRange(sheet,
          new CellRangeAddress(0, 0, 0, NUM_OF_COLUMNS - 1));
      XDDFNumericalDataSource<Double> val = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
          new CellRangeAddress(1, 1, 0, NUM_OF_COLUMNS - 1));

      XDDFChartData data = new XDDFPieChartData(chart.getCTChart().getPlotArea().addNewPieChart());
      data.setVaryColors(true);
      data.addSeries(cat, val);
      chart.plot(data);

      // Write the output to a file
      try (FileOutputStream fileOut = new FileOutputStream("ooxml-pie-chart.xlsx")) {
        wb.write(fileOut);
      }
    }
  }
}