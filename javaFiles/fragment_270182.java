import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.*;
import org.apache.poi.xddf.usermodel.chart.*;
import org.apache.poi.xssf.usermodel.*;

public class PieChartFromArray {

    public static void main(String[] args) throws IOException {
        try (XSSFWorkbook wb = new XSSFWorkbook()) {
            XSSFSheet sheet = wb.createSheet("barchart");

            XSSFDrawing drawing = sheet.createDrawingPatriarch();
            XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 0, 6, 15);

            XSSFChart chart = drawing.createChart(anchor);
            chart.setTitleText("Chart title");
            chart.setTitleOverlay(false);

            XDDFChartLegend legend = chart.getOrAddLegend();
            legend.setPosition(LegendPosition.RIGHT);

            XDDFDataSource<String> cat = XDDFDataSourcesFactory.fromArray(new String[]{"Russia","Canada","USA"});
            XDDFNumericalDataSource<Double> val = XDDFDataSourcesFactory.fromArray(new Double[]{170d, 99d, 98d});

            //XDDFChartData data = new XDDFPieChartData(chart.getCTChart().getPlotArea().addNewPieChart());
            XDDFChartData data = chart.createData(ChartTypes.PIE, null, null);
            data.setVaryColors(true);
            XDDFChartData.Series series = data.addSeries(cat, val);
            series.setTitle("Series", null);
            chart.plot(data);

            try (FileOutputStream fileOut = new FileOutputStream("ooxml-pie-chart.xlsx")) {
                wb.write(fileOut);
            }
        }
    }
}