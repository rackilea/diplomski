import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation; // ***
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation; // ***
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class StackOverflow25993430b extends JFrame {

    public StackOverflow25993430b(String title) {
        super(title);
        JFreeChart chart = createChart(createDataset());
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(500, 300));
        setContentPane(panel);
    }

    private XYDataset createDataset() {
        XYSeries s1 = new XYSeries("S1");
        s1.add(0, 0);
        s1.add(1, 2);
        s1.add(2, 5);
        s1.add(3, 10);
        s1.add(4, 7);
        s1.add(5, 8);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);
        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "StackOverflow25993430b", "X", "Y", dataset);
        chart.removeLegend();
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setOrientation(PlotOrientation.HORIZONTAL); // ***
        plot.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT); // ***
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesShape(0, new Ellipse2D.Double(-4.0, -4.0, 8.0, 8.0));
        renderer.setSeriesFillPaint(0, Color.WHITE);
        renderer.setUseFillPaint(true);
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        xAxis.setInverted(true); // ***
        return chart;
    }

    public static void main(String[] args) {
        JFrame app = new StackOverflow25993430b("JFreeChart");
        app.pack();
        app.setVisible(true);
    }
}