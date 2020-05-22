import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Shape;
import java.util.Arrays;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

public class ScatterColors extends JFrame {

    private static final Color centroidColor = Color.blue;
    private int centroidColumn;

    public ScatterColors(String title, final double[][] samples) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DefaultXYDataset dataset = new DefaultXYDataset();
        dataset.addSeries("Series", createSeries(0, samples));
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart, false);
        chartPanel.setPreferredSize(new Dimension(500, 400));
        this.add(chartPanel, BorderLayout.CENTER);
    }

    private double[][] createSeries(int mean, double[][] samples) {
        centroidColumn = samples.length;
        double[][] series = new double[2][samples.length + 1];
        double p = 0, q = 0;
        for (int i = 0; i < samples.length; i++) {
            series[0][i] = samples[i][0];
            p = p + samples[i][0];
            series[1][i] = samples[i][1];
            q = q + samples[i][1];
        }
        series[0][samples.length] = p / samples.length;
        series[1][samples.length] = q / samples.length;
        for (int i = 0; i < series.length; i++) {
            System.out.println(Arrays.toString(series[i]));
        }
        return series;
    }

    private JFreeChart createChart(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createScatterPlot(
            "Scatter Plot Demo", "X", "Y", dataset,
            PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.white);
        XYPlot plot = (XYPlot) chart.getPlot();
        Shape[] cross = DefaultDrawingSupplier.createStandardSeriesShapes();
        plot.setBackgroundPaint(new Color(0xffffe0));
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.lightGray);
        MyRenderer renderer = new MyRenderer(false, true);
        plot.setRenderer(renderer);
        renderer.setSeriesShape(0, cross[0]);
        plot.setRenderer(renderer);
        return chart;
    }

    private class MyRenderer extends XYLineAndShapeRenderer {

        public MyRenderer(boolean lines, boolean shapes) {
            super(lines, shapes);
        }

        @Override
        public Paint getItemPaint(int row, int col) {
            if (col == centroidColumn) {
                return centroidColor;
            } else {
                return super.getItemPaint(row, col);
            }
        }
    }

    public static void main(String[] args) {
        double[][] trainingSet = {
            {0.428053, 0.409742,},
            {0.415487, 0.401414,},
            {0.404834, 0.400493,},
        };
        ScatterColors demo = new ScatterColors("JFreeChartDemo", trainingSet);
        demo.pack();
        demo.setLocationRelativeTo(null);
        demo.setVisible(true);
    }
}