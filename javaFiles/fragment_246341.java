import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.util.List;

import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.*;
import org.jfree.ui.*;

public class CategoryLabelWithShape extends ApplicationFrame {

    public CategoryLabelWithShape(final String title) {
        super(title);
        final JFreeChart chart = constructChart();
        final ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    JFreeChart constructChart() {
        JFreeChart chart = ChartFactory.createXYBarChart(
            "State Executions","Year",true,"Number of people",getDataSet(),PlotOrientation.VERTICAL,true,true,false
        );

        XYPlot xyPlot = (XYPlot)chart.getPlot();
        final XYItemRenderer xyRend = xyPlot.getRenderer();

        DateAxis daNew = new DateAxis(){
            /**
             * Draws the axis line, tick marks and tick mark labels.
             *
             * @param g2  the graphics device.
             * @param cursor  the cursor.
             * @param plotArea  the plot area.
             * @param dataArea  the data area.
             * @param edge  the edge that the axis is aligned with.
             *
             * @return The width or height used to draw the axis.
             */
            protected AxisState drawTickMarksAndLabels(Graphics2D g2,
                    double cursor, Rectangle2D plotArea, Rectangle2D dataArea,
                    RectangleEdge edge) {

                if (isTickLabelsVisible()) {
                    Shape s = xyRend.getBaseShape();
                    Paint oldPaint = g2.getPaint();
                    g2.setPaint(xyRend.getSeriesPaint(0));
                    Rectangle2D rect = s.getBounds2D();
                    AffineTransform oldTrans = g2.getTransform();

                    AxisState state = new AxisState(cursor);
                    @SuppressWarnings("unchecked")
                    List<ValueTick> ticks = (List<ValueTick>)refreshTicks(g2, state, dataArea, edge);
                    for (ValueTick tick : ticks) {
                        float[] anchorPoint = calculateAnchorPoint(tick, cursor, dataArea, edge);
                        g2.setTransform(oldTrans);
                        // TODO: replace "anchorPoint[0]-X" with a bounds based value
                        g2.translate(anchorPoint[0]-17, anchorPoint[1]+rect.getHeight());
                        g2.fill(s);
                    }


                    g2.setPaint(oldPaint);
                    g2.setTransform(oldTrans);
                }

                return super.drawTickMarksAndLabels(g2,cursor,plotArea,dataArea,edge);
            }
        };

        daNew.setLabel(xyPlot.getDomainAxis().getLabel());
        xyPlot.setDomainAxis(daNew);

        return chart;
    }

    private TimeSeriesCollection getDataSet() {
        TimeSeriesCollection ds = new TimeSeriesCollection();

        final TimeSeries s1 = new TimeSeries("Executions");
        ds.addSeries(s1);

        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.YEAR, 1970);
        Random rand = new Random();
        for (int i=0; i<(2010-1970); i++) {
            s1.add(new Year(cal.getTime()), rand.nextInt(100));
            cal.add(Calendar.YEAR, 1);
        }

        return ds;
    }


    public static void main(String[] args) {
        CategoryLabelWithShape demo = new CategoryLabelWithShape(
                "Category-label with a shape");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}