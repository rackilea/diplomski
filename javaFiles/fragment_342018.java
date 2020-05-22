import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/** @see https://stackoverflow.com/q/9843451/230513 */
public class ResponseTime {

    private static final int N = 600;
    private static final String title = "ResponseTime";
    private static final Random random = new Random();
    private static final Shape circle = new Ellipse2D.Double(-3, -3, 6, 6);
    private static final Color line = Color.gray;

    private ChartPanel createPanel() {
        JFreeChart chart = ChartFactory.createXYLineChart(
            title, "Elapsed Time (secs)", "Response Time (secs)",
            createDataset(), PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = chart.getXYPlot();
        MyRenderer renderer = new MyRenderer(true, true, N);
        plot.setRenderer(renderer);
        renderer.setSeriesShape(0, circle);
        renderer.setSeriesPaint(0, line);
        renderer.setUseFillPaint(true);
        renderer.setSeriesShapesFilled(0, true);
        renderer.setSeriesShapesVisible(0, true);
        renderer.setUseOutlinePaint(true);
        renderer.setSeriesOutlinePaint(0, line);
        ValueAxis range = plot.getRangeAxis();
        range.setLowerBound(0.5);
        return new ChartPanel(chart);
    }

    private static class MyRenderer extends XYLineAndShapeRenderer {

        private List<Color> clut;

        public MyRenderer(boolean lines, boolean shapes, int n) {
            super(lines, shapes);
            clut = new ArrayList<Color>(n);
            for (int i = 0; i < n; i++) {
                clut.add(Color.getHSBColor((float) i / n, 1, 1));
            }
        }

        @Override
        public Paint getItemFillPaint(int row, int column) {
            return clut.get(column);
        }
    }

    private XYDataset createDataset() {
        XYSeriesCollection result = new XYSeriesCollection();
        XYSeries series = new XYSeries("Series 1");
        for (double x = 0; x < N - 1; x++) {
            series.add(x, f(x));
        }
        series.add(25, 1.75); // outlier
        result.addSeries(series);
        return result;
    }

    private double f(double x) {
        double y = 0.004 * x + .75;
        return y + random.nextGaussian() * y / 10;
    }

    private void display() {
        JFrame f = new JFrame(title);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(createPanel());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ResponseTime().display();
            }
        });
    }
}