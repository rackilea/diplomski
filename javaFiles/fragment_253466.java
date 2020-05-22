import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import javax.swing.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeListener;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleEdge;

public class Runner {

    private static Random rand = new Random();

    public static void main(String[] args) {
        XYSeriesCollection data = new XYSeriesCollection();
        int max = rand.nextInt(2) + 2;
        for (int i = 0; i < max; i++) {
            data.addSeries(generateSeries("Series" + (i + 1)));
        }
        final XYItemRenderer renderer1 = new StandardXYItemRenderer();
        final XYPlot plot1 = new XYPlot(data, null, new DateAxis("Dates"), renderer1);

        data = new XYSeriesCollection();
        for (int i = 0; i < max; i++) {
            data.addSeries(generateSeries("Series" + (i + 1)));
        }
        final XYPlot plot2 = new XYPlot(data, null, new NumberAxis("Numbers"), renderer1);

        final CombinedDomainXYPlot plot = new CombinedDomainXYPlot(new NumberAxis("Domain"));
        plot.setGap(10.0);

        // add the subplots...
        plot.add(plot1, 1);
        plot.add(plot2, 1);
        plot.setOrientation(PlotOrientation.VERTICAL);

        // return a new chart containing the overlaid plot...
        final JFreeChart chart = new JFreeChart("CombinedDomainXYPlot Demo",
            JFreeChart.DEFAULT_TITLE_FONT, plot, true);
        chart.getLegend().setPosition(RectangleEdge.RIGHT);

        chart.addChangeListener(new ChartChangeListener() {

            boolean changed = false;

            @Override
            public void chartChanged(ChartChangeEvent event) {
                if (!changed) {
                } else {
                    changed = false;
                }
            }
        });

        ChartPanel panel = new ChartPanel(chart);
        JPanel panel2 = new JPanel(new BorderLayout(0, 10));
        panel2.add(panel, BorderLayout.CENTER);
        JButton b = new JButton("Click");
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CombinedDomainXYPlot plot = (CombinedDomainXYPlot) chart.getXYPlot();
                List l = plot.getSubplots();
                int index = rand.nextInt(plot1.getSeriesCount() + plot2.getSeriesCount());
                boolean b = renderer1.isSeriesVisible(index);
                renderer1.setSeriesVisible(index, false);
            }
        });
        panel2.add(b, BorderLayout.NORTH);
        panel2.setVisible(true);

        JFrame frame = new JFrame("dsadsa");
        frame.add(panel2);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    private static XYSeries generateSeries(String key) {
        XYSeries series = new XYSeries(key);
        int points = 15;
        double val = 0.0;
        double x = 0.0;
        for (int i = 0; i < points; i++) {
            val += rand.nextDouble() * 6 - 3;
            x += rand.nextDouble() * 4;
            series.add(x, val);
        }
        return series;
    }
}