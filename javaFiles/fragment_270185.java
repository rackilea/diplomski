import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xddf.usermodel.PresetColor;
import org.apache.poi.xddf.usermodel.XDDFColor;
import org.apache.poi.xddf.usermodel.XDDFShapeProperties;
import org.apache.poi.xddf.usermodel.XDDFSolidFillProperties;
import org.apache.poi.xddf.usermodel.chart.AxisCrosses;
import org.apache.poi.xddf.usermodel.chart.AxisPosition;
import org.apache.poi.xddf.usermodel.chart.AxisCrossBetween;
import org.apache.poi.xddf.usermodel.chart.BarDirection;
import org.apache.poi.xddf.usermodel.chart.ChartTypes;
import org.apache.poi.xddf.usermodel.chart.LegendPosition;
import org.apache.poi.xddf.usermodel.chart.XDDFBarChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFCategoryAxis;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFChartLegend;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFValueAxis;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BarChart {

  public static void main(String[] args) throws Exception {

    String[] categories = new String[]{"Russia","Canada","USA"};
    Double[] values = new Double[]{170d, 99d, 98d};

    try (XSSFWorkbook wb = new XSSFWorkbook()) {
      //the sheet for the chart
      XSSFSheet chartSheet = wb.createSheet("barchart");
      //the sheet for the data
      XSSFSheet dataSheet = wb.createSheet("data");
      //maybe hide the data sheet
      //wb.setSheetHidden(1, true);

      Row row;
      Cell cell;
      row = dataSheet.createRow(0);
      cell = row.createCell(1); cell.setCellValue("Series");
      for (int i = 1; i <= categories.length; i++) {
        row = dataSheet.createRow(i);
        cell = row.createCell(0); cell.setCellValue(categories[i-1]);
        cell = row.createCell(1); cell.setCellValue(values[i-1]);
      }

      XSSFDrawing drawing = chartSheet.createDrawingPatriarch();
      XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 0, 10, 15);

      XSSFChart chart = drawing.createChart(anchor);
      chart.setTitleText("Chart title");
      chart.setTitleOverlay(false);

      XDDFChartLegend legend = chart.getOrAddLegend();
      legend.setPosition(LegendPosition.RIGHT);

      XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
      bottomAxis.setTitle("cat");

      XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
      leftAxis.setTitle("val");
      leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
      leftAxis.setCrossBetween(AxisCrossBetween.BETWEEN);

      XDDFDataSource<String> cat = XDDFDataSourcesFactory.fromStringCellRange(dataSheet,
          new CellRangeAddress(1, categories.length, 0, 0));
      XDDFNumericalDataSource<Double> val = XDDFDataSourcesFactory.fromNumericCellRange(dataSheet,
          new CellRangeAddress(1, categories.length, 1, 1));

      XDDFChartData data = chart.createData(ChartTypes.BAR, bottomAxis, leftAxis);
      data.setVaryColors(false);
      XDDFChartData.Series series = data.addSeries(cat, val);
      series.setTitle(dataSheet.getRow(0).getCell(1).getStringCellValue(), new CellReference(dataSheet.getRow(0).getCell(1)));
      solidFillSeries(series, PresetColor.BLUE);
      chart.plot(data);

      XDDFBarChartData bar = (XDDFBarChartData) data;
      bar.setBarDirection(BarDirection.COL);

      // Do not auto delete the title; is necessary for showing title in Calc
      if (chart.getCTChart().getAutoTitleDeleted() == null) chart.getCTChart().addNewAutoTitleDeleted();
      chart.getCTChart().getAutoTitleDeleted().setVal(false);

      try (FileOutputStream fileOut = new FileOutputStream("ooxml-bar-chart.xlsx")) {
        wb.write(fileOut);
      }
    }
  }

  private static void solidFillSeries(XDDFChartData.Series series, PresetColor color) {
    XDDFSolidFillProperties fill = new XDDFSolidFillProperties(XDDFColor.from(color));
    XDDFShapeProperties properties = series.getShapeProperties();
    if (properties == null) {
      properties = new XDDFShapeProperties();
    }
    properties.setFillProperties(fill);
    series.setShapeProperties(properties);
  }
}