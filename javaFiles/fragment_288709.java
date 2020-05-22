import java.io.File;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer;
import org.jfree.data.time.TimeTableXYDataset;
import org.jfree.data.time.Year;
import org.jfree.data.xy.TableXYDataset;

public class StackedAreaChart2 {

    public StackedAreaChart2() {
        TimeTableXYDataset[] dataset = createDataset();
        createChart(dataset);
    }

    public TimeTableXYDataset[] createDataset() {
        TimeTableXYDataset dataSet1 = new TimeTableXYDataset();

        dataSet1.add(new Year(2001), 1.0,"Series1");
        dataSet1.add(new Year(2002), 2.0,"Series1");
        dataSet1.add(new Year(2003),3.0,"Series1");
        dataSet1.add(new Year(2004),4.0,"Series1");
        dataSet1.add(new Year(2005),5.0,"Series1");
        dataSet1.add(new Year(2006),0,"Series1");

        dataSet1.add(new Year(2001), 6.0,"Series2");
        dataSet1.add(new Year(2002),3.0,"Series2");
        dataSet1.add(new Year(2003),4.0,"Series2");
        dataSet1.add(new Year(2004),3.0,"Series2");
        dataSet1.add(new Year(2005),9.0,"Series2");
        dataSet1.add(new Year(2006),0,"Series2");

        TimeTableXYDataset dataSet2 = new TimeTableXYDataset();
        dataSet2.add(new Year(2006),-2,"Series3");
        dataSet2.add(new Year(2007),-3,"Series3");
        dataSet2.add(new Year(2008),-4,"Series3");  

        return new TimeTableXYDataset[] {dataSet1,dataSet2};
    }

    public JFreeChart createChart(TableXYDataset[]  dataset) {
        final JFreeChart chart = ChartFactory.createStackedXYAreaChart("","","",dataset[0],PlotOrientation.VERTICAL,true,true,false);
        XYPlot plot = (XYPlot) chart.getPlot();        
        StackedXYAreaRenderer renderer2 = new StackedXYAreaRenderer();
        plot.setDataset(1, dataset[1]);
        plot.setRenderer(1, renderer2);
        NumberAxis axis = (NumberAxis) plot.getDomainAxis();
        axis.setNumberFormatOverride(new NumberFormat(){

            @Override
            public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
                  SimpleDateFormat format = new SimpleDateFormat("YYYY");   
                  return toAppendTo.append(format.format(new Date((long) number)));
                }

            @Override
            public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
                return new StringBuffer(String.format("%s", number));
            }

            @Override
            public Number parse(String source, ParsePosition parsePosition) {
                return null;
            }
        });
        return chart;
    }

    public void saveChart(JFreeChart chart, String fileLocation) {
        String fileName = fileLocation;
        try {
            ChartUtilities.saveChartAsPNG(new File(fileName), chart, 1000, 600);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Problem occurred creating chart.");
        }
    }

    public static void main(final String[] args) {
        final StackedAreaChart2 demo = new StackedAreaChart2();
        TableXYDataset[] categoryDataset = demo.createDataset();
        JFreeChart chart = demo.createChart(categoryDataset);
        String fileLocation = "StackAreaChart.png";
        demo.saveChart(chart, fileLocation);
        System.out.println("Pie Chart has been created successfully");
        System.out.println("Chart has been saved to: " + fileLocation);
    }

}