import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;

/** @see https://stackoverflow.com/a/45173688/230513 */
public class CSVTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ApplicationFrame frame = new ApplicationFrame("CSVTest");
            CSVTest test = new CSVTest();
            frame.add(test.createChart("Temperature profile"));
            frame.pack();
            frame.setLocationRelativeTo(null);;
            frame.setVisible(true);
        });
    }

    private ChartPanel createChart(String chartTitle) {
        JFreeChart chart = ChartFactory.createTimeSeriesChart(chartTitle,
            "Time", "Temperature", createDataset(), true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);
        XYLineAndShapeRenderer r = (XYLineAndShapeRenderer) plot.getRenderer();
        r.setBaseShapesVisible(true);
        DateAxis axis = (DateAxis) plot.getDomainAxis();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ssX");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        axis.setDateFormatOverride(df);
        return chartPanel;
    }

    private XYDataset createDataset() {
        TimeSeries series = new TimeSeries("Temperature");
        TimeSeriesCollection dataset = new TimeSeriesCollection(series);
        try (FileReader fr = new FileReader("temp.csv");
            BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] s = line.split(",");
                ZonedDateTime zdt = ZonedDateTime.parse(s[0]);
                Second second = new Second(Date.from(zdt.toInstant()));
                series.add(second, Double.valueOf(s[2]));
            }
        } catch (IOException | SeriesException e) {
            System.err.println("Error: " + e);
        }
        return dataset;
    }
}