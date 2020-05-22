import java.awt.EventQueue;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.IntervalCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;

/**
 * @see https://stackoverflow.com/a/15241250/230513
 */
public class Test {

    class MyToolTipGenerator extends IntervalCategoryToolTipGenerator {

        DateFormat format;

        private MyToolTipGenerator(String value, DateFormat format) {
            super(value, format);
            this.format = format;
        }

        @Override
        public String generateToolTip(CategoryDataset cds, int row, int col) {
            final String s = super.generateToolTip(cds, row, col);
            TaskSeriesCollection tsc = (TaskSeriesCollection) cds;
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < tsc.getSubIntervalCount(row, col); i++) {
                sb.append(format.format(tsc.getStartValue(row, col, i)));
                sb.append("-");
                sb.append(format.format(tsc.getEndValue(row, col, i)));
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
    }

    private JFreeChart createChart() {
        IntervalCategoryDataset xyDataset = createDataset();
        JFreeChart jFreeChart = ChartFactory.createGanttChart("Gantt",
            "time", "value", xyDataset, true, true, true);
        CategoryPlot plot = jFreeChart.getCategoryPlot();
        plot.getRenderer().setBaseToolTipGenerator(
            new MyToolTipGenerator(
            "{0}, {1}: ", DateFormat.getTimeInstance(DateFormat.SHORT)));
        return jFreeChart;
    }

    private IntervalCategoryDataset createDataset() {
        TaskSeriesCollection dataset = new TaskSeriesCollection();
        TaskSeries unavailable = new TaskSeries("Unavailable");
        Task t1 = new Task("Meeting Room 1", date(7), date(18));
        t1.addSubtask(new Task("Meeting 1", date(9), date(16)));
        unavailable.add(t1);

        Task t2 = new Task("Meeting Room 2", date(8), date(18));
        t2.addSubtask(new Task("Meeting 4", date(10), date(11)));
        t2.addSubtask(new Task("Meeting 5", date(13), date(15)));
        t2.addSubtask(new Task("Meeting 6", date(16), date(18)));
        unavailable.add(t2);
        dataset.add(unavailable);
        return dataset;
    }

    private Date date(int hour) {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(2009, Calendar.DECEMBER, 1, hour, 0, 0);
        return calendar.getTime();
    }

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new ChartPanel(createChart()));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test().display();
            }
        });
    }
}