package chart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class chartExample extends ApplicationFrame {

    private static final long serialVersionUID = 1L;

    public chartExample(final String title) {
        super(title);
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(600, 350));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset() {

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1.0, "Line", "2009");
        dataset.addValue(2.0, "Line", "2010");

        return dataset;

    }

    private JFreeChart createChart(final CategoryDataset dataset) {

        final JFreeChart chart = ChartFactory.createLineChart(
            "",                        // chart title
            "",                        // domain axis label
            "",                        // range axis label
            dataset,                   // data
            PlotOrientation.VERTICAL,  // orientation
            true,                      // include legend
            true,                      // tooltips
            false                      // urls
        );

        chart.setBackgroundPaint(Color.WHITE);

        final CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeZeroBaselinePaint(Color.RED);
        plot.setOutlineVisible(false);
        plot.setRangeGridlinePaint(Color.white);
        plot.setDomainGridlinePaint(Color.BLUE);        

        final CategoryAxis categoryAxis = (CategoryAxis) plot.getDomainAxis();
        categoryAxis.setAxisLineVisible(false);
        categoryAxis.setTickMarksVisible(false);
        //categoryAxis.setVisible(false);

        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        //rangeAxis.setAxisLineVisible(false);
        rangeAxis.setVisible(false);
        rangeAxis.setLabelPaint(Color.BLUE);
        rangeAxis.setRange(0, 3);

        final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        //renderer.setItemLabelsVisible(false); //Deprecated. 
        renderer.setBaseShapesVisible(true);
        renderer.setBaseShapesFilled(true);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        Shape circle = new Ellipse2D.Double(-3, -3, 6, 6);
        renderer.setSeriesShape(0, circle);
        plot.getRenderer().setSeriesPaint(0, Color.BLUE);

        // Removed and added a main method.
        //try {
        //    ChartUtilities.saveChartAsPNG(new File("E:\\jfreeLinechart.png"), chart, 211, 90);
        //    System.out.println("=====chart=====");
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}


        return chart;
    }

    public static void main(final String[] args) {

        final chartExample ce = new chartExample("Chart Example");
        ce.pack();
        RefineryUtilities.centerFrameOnScreen(ce);
        ce.setVisible(true);

    }

}