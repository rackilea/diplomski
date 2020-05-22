import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.*;
import org.apache.poi.xddf.usermodel.chart.*;
import org.apache.poi.xssf.usermodel.*;

public class BarChartFromArray {

    public static void main(String[] args) throws IOException {
        try (XSSFWorkbook wb = new XSSFWorkbook()) {
            XSSFSheet sheet = wb.createSheet("barchart");

            XSSFDrawing drawing = sheet.createDrawingPatriarch();
            XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 0, 10, 15);

            XSSFChart chart = drawing.createChart(anchor);
            chart.setTitleText("Chart title");
            chart.setTitleOverlay(false);

            XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
            bottomAxis.setTitle("cat");
            XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
            leftAxis.setTitle("val");
            leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
            leftAxis.setCrossBetween(AxisCrossBetween.BETWEEN);

            XDDFDataSource<String> cat = XDDFDataSourcesFactory.fromArray(new String[]{"Russia","Canada","USA"});
            XDDFNumericalDataSource<Double> val = XDDFDataSourcesFactory.fromArray(new Double[]{170d, 99d, 98d});

            XDDFChartData data = chart.createData(ChartTypes.BAR, bottomAxis, leftAxis);
            data.setVaryColors(false);
            XDDFChartData.Series series = data.addSeries(cat, val);
            series.setTitle("Series", null);
            chart.plot(data);

            XDDFBarChartData bar = (XDDFBarChartData) data;
            bar.setBarDirection(BarDirection.COL);

            try (FileOutputStream fileOut = new FileOutputStream("ooxml-bar-chart.xlsx")) {
                wb.write(fileOut);
            }
        }
    }
}