import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @See https://stackoverflow.com/a/53912014/230513
 * @see https://stackoverflow.com/a/22450677/230513
 * @see https://stackoverflow.com/a/10353270/230513
 */
public class Test {

    private static final int N = 10;

    private void display() {
        XYSeries series = new XYSeries("Series");
        for (int i = -N; i <= N; i++) {
            series.add(i, i);
        }
        LogarithmicAxis xAxis = new LogarithmicAxis("X");
        xAxis.setAllowNegativesFlag(true);
        LogarithmicAxis yAxis = new LogarithmicAxis("Y");
        yAxis.setAllowNegativesFlag(true);
        XYPlot plot = new XYPlot(new XYSeriesCollection(series),
            xAxis, yAxis, new XYLineAndShapeRenderer(true, false));
        JFreeChart chart = new JFreeChart(
            "Chart", JFreeChart.DEFAULT_TITLE_FONT, plot, false);

        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new ChartPanel(chart) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(700, 400);
            }
        });
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Test().display();
            }
        });
    }
}