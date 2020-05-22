import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.BasicStroke;
import java.text.NumberFormat;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

//** @see https://stackoverflow.com/a/54097313/230513 */
public class ChartOne {

    public static ChartPanel createChart() {

        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries x1 = new XYSeries("Series 1");
        x1.add(0.5, 2);
        x1.add(1, 2.2);
        x1.add(2, 2.4);
        x1.add(10, 2.75);
        x1.add(30, 4);
        x1.add(120, 7);
        dataset.addSeries(x1);
        XYSeries x2 = new XYSeries("Series 2");
        x2.add(0.5, 6);
        x2.add(1, 7);
        x2.add(2, 8);
        x2.add(10, 14);
        x2.add(30, 18);
        x2.add(120, 22);
        dataset.addSeries(x2);

        JFreeChart chart = ChartFactory.createXYLineChart(
            "Data", "Exposure", "Percentage uptake", dataset,
            PlotOrientation.VERTICAL, false,  true, false);

        LogarithmicAxis xAxis = new LogarithmicAxis("Time");
        xAxis.setTickUnit(new NumberTickUnit(1.0, NumberFormat.getInstance(), 9));
                xAxis.setTickMarkInsideLength(2f);
                xAxis.setTickMarkOutsideLength(4f);
                xAxis.setTickMarkPaint(Color.GREEN);
                xAxis.setTickMarkStroke(new BasicStroke(2f));
        xAxis.setMinorTickMarksVisible(true);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setDomainAxis(xAxis);
        plot.setDomainMinorGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);
        plot.setDomainMinorGridlinePaint(Color.BLACK);
        plot.setBackgroundPaint(Color.WHITE);
        return new ChartPanel(chart){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(600, 400);
            }
        };
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Chart");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(createChart(), BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}