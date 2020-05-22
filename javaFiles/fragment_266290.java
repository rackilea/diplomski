import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
import static org.jfree.chart.ChartPanel.*;

/** @see https://stackoverflow.com/a/41337259/230513 */
public class ZoomDemo {

    private static final String TITLE = "Return On Investment";
    private final ChartPanel chartPanel = createChart();

    public ZoomDemo() {
        JFrame f = new JFrame(TITLE);
        f.setTitle(TITLE);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout(0, 5));
        f.add(chartPanel, BorderLayout.CENTER);
        chartPanel.setMouseWheelEnabled(true);

        JPanel panel = new JPanel();
        JToolBar toolBar = new JToolBar();
        toolBar.add(createButton("Zoom In", ZOOM_IN_BOTH_COMMAND));
        toolBar.add(createButton("Zoom In X", ZOOM_IN_DOMAIN_COMMAND));
        toolBar.add(createButton("Zoom In Y", ZOOM_IN_RANGE_COMMAND));
        toolBar.add(createButton("Zoom Out", ZOOM_OUT_BOTH_COMMAND));
        toolBar.add(createButton("Zoom Out X", ZOOM_OUT_DOMAIN_COMMAND));
        toolBar.add(createButton("Zoom Out Y", ZOOM_OUT_RANGE_COMMAND));
        toolBar.add(createButton("Reset", ZOOM_RESET_BOTH_COMMAND));
        toolBar.add(createButton("Reset X", ZOOM_RESET_DOMAIN_COMMAND));
        toolBar.add(createButton("Reset Y", ZOOM_RESET_RANGE_COMMAND));
        panel.add(toolBar);
        f.add(panel, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private JButton createButton(String name, String command) {
        final JButton b = new JButton(name);
        b.setActionCommand(command);
        b.addActionListener(chartPanel);
        return b;
    }

    private ChartPanel createChart() {
        XYDataset roiData = createDataset();
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            TITLE, "Date", "Value", roiData, true, true, false);
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer =
            (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseShapesVisible(true);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        currency.setMaximumFractionDigits(0);
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setNumberFormatOverride(currency);
        return new ChartPanel(chart);
    }

    private XYDataset createDataset() {
        TimeSeriesCollection tsc = new TimeSeriesCollection();
        tsc.addSeries(createSeries("Projected", 200));
        tsc.addSeries(createSeries("Actual", 100));
        return tsc;
    }

    private TimeSeries createSeries(String name, double scale) {
        TimeSeries series = new TimeSeries(name);
        for (int i = 0; i < 6; i++) {
            series.add(new Year(2016 + i), Math.pow(2, i) * scale);
        }
        return series;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ZoomDemo cpd = new ZoomDemo();
            }
        });
    }
}