import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

/**
 * @see https://stackoverflow.com/a/14894894/230513
 */
public class Test {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Test t = new Test();
            }
        });
    }

    public Test() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final MyJPanel myPanel = new MyJPanel();
        f.add(myPanel, BorderLayout.CENTER);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        myPanel.start();
    }

    private static class MyJPanel extends JPanel {

        private static final Random r = new Random();
        private ChartPanel chartPanel;
        private JFreeChart chart;
        private XYPlot subplotTop;
        private XYPlot subplotBottom;
        private CombinedDomainXYPlot plot;
        private Timer timer;
        private Day now = new Day(new Date());

        public MyJPanel() {
            createCombinedChart();
            chartPanel = new ChartPanel(chart);
            this.add(chartPanel);
            timer = new Timer(1000, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    update(subplotTop);
                    update(subplotBottom);
                    now = (Day) now.next();
                }
            });
            chartPanel.addChartMouseListener(new ChartMouseListener() {

                @Override
                public void chartMouseClicked(ChartMouseEvent e) {
                    final ChartEntity entity = e.getEntity();
                    System.out.println(entity + " " + entity.getArea());
                }

                @Override
                public void chartMouseMoved(ChartMouseEvent e) {
                }
            });
        }

        public void start() {
            timer.start();
        }

        private void update(XYPlot plot) {
            TimeSeriesCollection t = (TimeSeriesCollection) plot.getDataset();
            for (int i = 0; i < t.getSeriesCount(); i++) {
                TimeSeries s = t.getSeries(i);
                s.add(now, Math.abs(r.nextGaussian()));
            }
        }

        private void createCombinedChart() {
            plot = new CombinedDomainXYPlot();
            createSubplots();
            plot.add(subplotTop, 4);
            plot.add(subplotBottom, 1);
            plot.setOrientation(PlotOrientation.VERTICAL);
            chart = new JFreeChart("Title",
                JFreeChart.DEFAULT_TITLE_FONT, plot, true);
            plot.setDomainAxis(new DateAxis("Domain"));
        }

        private void createSubplots() {
            subplotTop = new XYPlot();
            subplotBottom = new XYPlot();
            subplotTop.setDataset(emptyDataset("Set 1"));
            subplotTop.setRenderer(new XYLineAndShapeRenderer());
            subplotTop.setRangeAxis(new NumberAxis("Range"));
            subplotBottom.setDataset(emptyDataset("Set 2"));
            subplotBottom.setRenderer(new XYLineAndShapeRenderer());
            subplotBottom.setRangeAxis(new NumberAxis("Range"));
        }

        private XYDataset emptyDataset(String title) {
            TimeSeriesCollection tsc = new TimeSeriesCollection();
            TimeSeries ts = new TimeSeries(title);
            tsc.addSeries(ts);
            return tsc;
        }
    }
}