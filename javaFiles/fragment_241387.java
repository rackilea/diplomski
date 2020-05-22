import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.XYPlot;
import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class App extends ApplicationFrame {

    XYSeries sin = new XYSeries("Sin");

    public App(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        JFreeChart xylineChart = ChartFactory.createXYLineChart(chartTitle, "X", "Y",                                                                                                 new XYSeriesCollection(sin),
            PlotOrientation.VERTICAL, false, true, false);

    ChartPanel chartPanel = new ChartPanel(xylineChart);
    chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
    final XYPlot plot = xylineChart.getXYPlot();

    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, false);
    plot.setRenderer(renderer);
    setContentPane(chartPanel);
}

public Runnable r = new Runnable() {
    double x, y;
    int i;

    public void run() {
        int steps = 69999;
        for (i = 0; i < steps; i++) {
            //sample plot data
            x = Math.PI * 2.0 * 10.0 / ((double) steps) * ((double) i);
            y = Math.sin(x);

            try {
                SwingUtilities.invokeAndWait(new Runnable() {
                    public void run() {
                        if ((i % 1000) == 0) {
                            //adding data and redrawing chart
                            sin.addOrUpdate(x, y);
                        } else {
                            //adding point without redrawing of the chart
                            sin.add(x, y, false);
                        }
                    }
                });
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //redrawing chart if all data loaded
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    sin.fireSeriesChanged();
                }
            });
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
};

public Runnable rupdate = new Runnable() {
    public void run() {
        while (true) {
            //redrawing chart
            try {
                SwingUtilities.invokeAndWait(new Runnable() {
                    public void run() {
                        sin.fireSeriesChanged();
                    }
                });
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //waiting for next update
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
};

public static void main(String[] args) {
    final App chart [] = new App[1];

    try {
        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                chart[0] = new App(null, null);
                chart[0].pack();
                RefineryUtilities.centerFrameOnScreen(chart[0]);
                chart[0].setVisible(true);
            }
        });
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    Thread job = new Thread(chart[0].r);
    job.start();
    Thread job2 = new Thread(chart[0].rupdate);
    job2.start();
}
}