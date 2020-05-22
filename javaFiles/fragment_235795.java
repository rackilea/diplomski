import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

class Sandbox {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1, "Test", "A");
        dataset.addValue(4, "Test", "B");
        dataset.addValue(3, "Test", "C");

        final JFreeChart chart = ChartFactory.createLineChart(
            "Test", "Domain", "Range", dataset,
            PlotOrientation.VERTICAL, true, true, false);

        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(5, 5));
        final ChartPanel cp = new ChartPanel(chart);
        frame.add(cp, BorderLayout.CENTER);

        Rectangle2D dataArea = cp.getChartRenderingInfo().getPlotInfo().getDataArea();
        System.out.println("dataArea = " + dataArea);

        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

        SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
            Rectangle2D dataArea = cp.getChartRenderingInfo().getPlotInfo().getDataArea();
            System.out.println("dataArea = " + dataArea);
          }
        });
      }
    });
  }
}