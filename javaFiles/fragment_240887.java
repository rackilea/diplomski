import com.jidesoft.swing.JideScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager2;
import java.awt.LinearGradientPaint;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class WorkSheetReport {

    public static final Color WORKING_HOURS_COLOR = new Color(93, 89, 88);
    public static final Color LUNCH_HOURS_COLOR = new Color(215, 142, 27);
    public static final Color OTHER_HOURS_COLOR = new Color(30, 141, 213);

    public static void main(String[] args) {
        new WorkSheetReport();
    }

    public WorkSheetReport() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                DefaultTimeSheetReport report = new DefaultTimeSheetReport();
                report.add(createTimeSheet(
                                "NWD/Full"));
                report.add(createTimeSheet(
                                "Present",
                                new DefaultTimeEntry(WorkType.WORK, 10, 12.5),
                                new DefaultTimeEntry(WorkType.LUNCH, 12.5, 13.25),
                                new DefaultTimeEntry(WorkType.WORK, 13.25, 18),
                                new DefaultTimeEntry(WorkType.OTHER, 18, 18.5),
                                new DefaultTimeEntry(WorkType.WORK, 18.5, 20.5)));
                report.add(createTimeSheet(
                                "0.5UUPL",
                                new DefaultTimeEntry(WorkType.WORK, 10, 12.5),
                                new DefaultTimeEntry(WorkType.LUNCH, 12.5, 17.75),
                                new DefaultTimeEntry(WorkType.OTHER, 17.75, 18),
                                new DefaultTimeEntry(WorkType.WORK, 18, 20)));
                report.add(createTimeSheet(
                                "Present",
                                new DefaultTimeEntry(WorkType.WORK, 11, 13),
                                new DefaultTimeEntry(WorkType.LUNCH, 13, 13.5),
                                new DefaultTimeEntry(WorkType.WORK, 13.5, 17.75),
                                new DefaultTimeEntry(WorkType.OTHER, 17.75, 18),
                                new DefaultTimeEntry(WorkType.WORK, 18, 20.5)));
                report.add(createTimeSheet(
                                "Present",
                                new DefaultTimeEntry(WorkType.WORK, 10, 12.75),
                                new DefaultTimeEntry(WorkType.LUNCH, 12.75, 13.5),
                                new DefaultTimeEntry(WorkType.WORK, 13.5, 17.5),
                                new DefaultTimeEntry(WorkType.OTHER, 17.5, 17.75),
                                new DefaultTimeEntry(WorkType.WORK, 17.75, 20.5)));
                report.add(createTimeSheet(
                                "Present",
                                new DefaultTimeEntry(WorkType.WORK, 9.75, 12),
                                new DefaultTimeEntry(WorkType.LUNCH, 12, 12.5),
                                new DefaultTimeEntry(WorkType.WORK, 12.5, 17.25),
                                new DefaultTimeEntry(WorkType.OTHER, 17.25, 17.75),
                                new DefaultTimeEntry(WorkType.WORK, 17.75, 20)));
                report.add(createTimeSheet(
                                "Present",
                                new DefaultTimeEntry(WorkType.WORK, 10, 11.75),
                                new DefaultTimeEntry(WorkType.LUNCH, 11.75, 12.25),
                                new DefaultTimeEntry(WorkType.WORK, 12.25, 17.5),
                                new DefaultTimeEntry(WorkType.OTHER, 17.5, 18),
                                new DefaultTimeEntry(WorkType.WORK, 18, 20.25)));
                report.add(createTimeSheet(
                                "NWD/Full"));
                report.add(createTimeSheet(
                                "Present",
                                new DefaultTimeEntry(WorkType.WORK, 10, 12.5),
                                new DefaultTimeEntry(WorkType.LUNCH, 12.5, 13.5),
                                new DefaultTimeEntry(WorkType.WORK, 13.5, 18),
                                new DefaultTimeEntry(WorkType.OTHER, 18, 18.5),
                                new DefaultTimeEntry(WorkType.WORK, 18.5, 20.5)));

                TimeSheetReportPane pane = new TimeSheetReportPane(report);

                JFrame frame = new JFrame("Testing");
                frame.getContentPane().setBackground(Color.BLACK);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JideScrollPane sp = new JideScrollPane(pane);
                sp.setColumnHeadersHeightUnified(true);
                frame.add(sp);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    protected TimeSheet createTimeSheet(String name, TimeEntry... entries) {
        DefaultTimeSheet ts = new DefaultTimeSheet(name);
        for (TimeEntry entry : entries) {
            ts.add(entry);
        }
        return ts;
    }

    protected static String format(double time) {
        time *= 60 * 60; // to seconds
        int hours = (int) Math.floor(time / (60 * 60));
        double remainder = time % (60 * 60);
        int mins = (int) Math.floor(remainder / 60);
        int secs = (int) Math.floor(time % 60);
        return hours + ":" + mins + ":" + secs;
    }

    public class TimeSheetReportPane extends JPanel {

        private TimeSheetReport report;

        private int columnWidth;
        private int rowHeight;

        public TimeSheetReportPane(TimeSheetReport report) {
            this.report = report;
            setLayout(new GridBagLayout());
            setBackground(Color.BLACK);

            FontMetrics fm = getFontMetrics(UIManager.getFont("Label.font"));
            columnWidth = fm.stringWidth("0000");
            rowHeight = fm.getHeight() + 8;

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(0, 0, 1, 0);

            int count = 0;
            for (TimeSheet ts : report) {

                Color color = getColorForSheet(count);
                TimeSheetPane pane = new TimeSheetPane(this, ts);
                pane.setBackground(color);
                add(pane, gbc);
                count++;

            }

            gbc.weighty = 1;
            JPanel fill = new JPanel();
            fill.setOpaque(false);
            add(fill, gbc);

        }

        public Color getColorForSheet(int index) {
            Color endColor = Color.GRAY;
            Color startColor = Color.DARK_GRAY;
            double progress = (double) index / (double) getReport().size();
            return blend(startColor, endColor, progress);
        }

        public TimeSheetReport getReport() {
            return report;
        }

        public int getRowHeight() {
            return rowHeight;
        }

        public int getColumnWidth() {
            return columnWidth;
        }

        @Override
        public void addNotify() {
            super.addNotify();
            configureEnclosingScrollPane();
        }

        protected void configureEnclosingScrollPane() {
            Container parent = getParent();
            if (parent instanceof JViewport) {
                JViewport viewport = (JViewport) parent;
                parent = viewport.getParent();
                if (parent instanceof JideScrollPane) {
                    JideScrollPane sp = (JideScrollPane) parent;
                    sp.setRowFooterView(new RowFooter(this));
                }
                if (parent instanceof JScrollPane) {
                    JScrollPane sp = (JScrollPane) parent;
                    JLabel leftHeader = new JLabel("Status");
                    leftHeader.setForeground(Color.WHITE);
                    leftHeader.setBackground(Color.BLACK);
                    leftHeader.setOpaque(true);
                    leftHeader.setHorizontalAlignment(JLabel.CENTER);
                    leftHeader.setVerticalAlignment(JLabel.TOP);
                    leftHeader.setBorder(new EdgeBorder(EdgeBorder.Edge.RIGHT, Color.WHITE, Color.BLACK));
                    sp.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, leftHeader);

                    JLabel rightHeader = new JLabel("Working Hr");
                    rightHeader.setForeground(Color.WHITE);
                    rightHeader.setBackground(Color.BLACK);
                    rightHeader.setOpaque(true);
                    rightHeader.setHorizontalAlignment(JLabel.CENTER);
                    rightHeader.setBorder(new EdgeBorder(EdgeBorder.Edge.LEFT, Color.WHITE, Color.BLACK));
                    sp.setCorner(ScrollPaneConstants.UPPER_RIGHT_CORNER, rightHeader);

                    sp.setRowHeaderView(new RowHeader(this));
                    sp.setColumnHeaderView(new ColumnHeader(this));
                }
            }
        }

    }

    public class ColumnHeader extends JPanel {

        private TimeSheetReportPane reportPane;

        public ColumnHeader(TimeSheetReportPane tsrp) {
            reportPane = tsrp;
            setBackground(Color.BLACK);
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridheight = GridBagConstraints.REMAINDER;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.ipady = 8;
            Border border = new MatteBorder(0, 0, 0, 1, Color.GRAY);

            for (int hour = 8; hour < 25; hour++) {
                JLabel label = new JLabel(Integer.toString(hour)) {

                    @Override
                    public Dimension getPreferredSize() {
                        Dimension dim = super.getPreferredSize();
                        dim.width = reportPane.getColumnWidth();
                        return dim;
                    }

                    @Override
                    public Dimension getMinimumSize() {
                        return getPreferredSize();
                    }

                };
                label.setVerticalAlignment(JLabel.TOP);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setForeground(Color.WHITE);
                label.setBorder(border);
                add(label, gbc);
            }
            gbc.weightx = 1;
            JPanel fill = new JPanel();
            fill.setOpaque(false);
            add(fill, gbc);

        }

    }

    public class RowHeader extends JPanel {

        private TimeSheetReportPane reportPane;

        public RowHeader(TimeSheetReportPane tsrp) {
            reportPane = tsrp;
            setBackground(Color.BLACK);
            setLayout(new GridBagLayout());
            TimeSheetReport tsr = reportPane.getReport();

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.ipadx = 16;
            gbc.ipady = 2;
            gbc.insets = new Insets(0, 0, 1, 0);

            int index = 0;
            for (TimeSheet ts : tsr) {
                JLabel label = new JLabel(ts.getName()) {

                    @Override
                    public Dimension getPreferredSize() {
                        Dimension dim = super.getPreferredSize();
                        dim.height = reportPane.getRowHeight();
                        return dim;
                    }

                    @Override
                    public Dimension getMinimumSize() {
                        return getPreferredSize();
                    }

                };
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setForeground(Color.WHITE);
                label.setBackground(reportPane.getColorForSheet(index));
                label.setOpaque(true);
                add(label, gbc);
                index++;
            }
            gbc.weighty = 1;
            JPanel fill = new JPanel();
            fill.setOpaque(false);
            add(fill, gbc);

        }

    }

    public class RowFooter extends JPanel {

        private TimeSheetReportPane reportPane;

        public RowFooter(TimeSheetReportPane tsrp) {
            reportPane = tsrp;
            setBackground(Color.BLACK);
            setLayout(new GridBagLayout());
            TimeSheetReport tsr = reportPane.getReport();

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.ipadx = 36;
            gbc.ipady = 2;
            gbc.insets = new Insets(0, 0, 1, 0);

            int index = 0;
            for (TimeSheet ts : tsr) {
                double time = ts.getWorkingHours();
                String workHrs = "";
                if (time > 0) {
                    workHrs = format(time);
                }
                JLabel label = new JLabel(workHrs) {

                    @Override
                    public Dimension getPreferredSize() {
                        Dimension dim = super.getPreferredSize();
                        dim.height = reportPane.getRowHeight();
                        return dim;
                    }

                    @Override
                    public Dimension getMinimumSize() {
                        return getPreferredSize();
                    }

                };
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setForeground(Color.WHITE);
                label.setBackground(reportPane.getColorForSheet(index));
                label.setOpaque(true);
                add(label, gbc);
                index++;
            }
            gbc.weighty = 1;
            JPanel fill = new JPanel();
            fill.setOpaque(false);
            add(fill, gbc);

        }

    }

    public static class EdgeBorder implements Border {

        public enum Edge {

            LEFT,
            RIGHT
        }

        private Edge edge;
        private Color startColor;
        private Color endColor;

        public EdgeBorder(Edge edge, Color startColor, Color endColor) {
            this.edge = edge;
            this.startColor = startColor;
            this.endColor = endColor;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

            int xPos = x;
            switch (edge) {
                case RIGHT:
                    xPos = x + (width - 1);
            }

            LinearGradientPaint lgp = new LinearGradientPaint(
                            new Point(x, 0),
                            new Point(x, height),
                            new float[]{0, 1},
                            new Color[]{startColor, endColor});

            Graphics2D g2d = (Graphics2D) g;
            g2d.setPaint(lgp);
            g2d.drawLine(xPos, y, xPos, y + height);
        }

        @Override
        public Insets getBorderInsets(Component c) {
            int left = edge == Edge.LEFT ? 1 : 0;
            int right = edge == Edge.RIGHT ? 1 : 0;
            return new Insets(0, left, 0, right);
        }

        @Override
        public boolean isBorderOpaque() {
            return false;
        }

    }

    /**
     * Blend two colors.
     *
     * @param color1 First color to blend.
     * @param color2 Second color to blend.
     * @param ratio Blend ratio. 0.5 will give even blend, 1.0 will return color1,
     * 0.0 will return color2 and so on.
     * @return Blended color.
     */
    public static Color blend(Color color1, Color color2, double ratio) {
        float r = (float) ratio;
        float ir = (float) 1.0 - r;

        float rgb1[] = new float[3];
        float rgb2[] = new float[3];

        color1.getColorComponents(rgb1);
        color2.getColorComponents(rgb2);

        float red = rgb1[0] * r + rgb2[0] * ir;
        float green = rgb1[1] * r + rgb2[1] * ir;
        float blue = rgb1[2] * r + rgb2[2] * ir;

        if (red < 0) {
            red = 0;
        } else if (red > 255) {
            red = 255;
        }
        if (green < 0) {
            green = 0;
        } else if (green > 255) {
            green = 255;
        }
        if (blue < 0) {
            blue = 0;
        } else if (blue > 255) {
            blue = 255;
        }

        Color color = null;
        try {

            color = new Color(red, green, blue);

        } catch (IllegalArgumentException exp) {
            exp.printStackTrace();
        }
        return color;
    }

    public class TimeSheetPane extends JPanel {

        private final JPanel timeEntriesPane;

        public TimeSheetPane(TimeSheetReportPane reportPane, TimeSheet ts) {

            timeEntriesPane = new JPanel(new TimeSheetLayoutManager(reportPane.getColumnWidth(), reportPane.getRowHeight()));
            timeEntriesPane.setBackground(Color.BLACK);

            setBorder(new EmptyBorder(1, 0, 1, 0));
            setLayout(new BorderLayout());
            add(timeEntriesPane);

            for (TimeEntry te : ts) {
                JLabel label = createLabel(te.getType().getColor());
                String startTime = format(te.getStartTime());
                String duration = format(te.getDuration());
                label.setToolTipText("<html>StartTime: " + startTime + "<br>Duration: " + duration);
                timeEntriesPane.add(label, te);
            }

        }

        protected JLabel createLabel(Color color) {
            JLabel label = new JLabel();
            label.setOpaque(true);
            label.setBackground(color);
            return label;
        }

    }

    public class TimeSheetLayoutManager implements LayoutManager2 {

        private Map<Component, TimeEntry> mapConstraints;
        private int colWidth;
        private int rowHeight;

        public TimeSheetLayoutManager(int colWidth, int rowHeight) {
            mapConstraints = new HashMap<>(25);
            this.colWidth = colWidth;
            this.rowHeight = rowHeight;
        }

        @Override
        public void addLayoutComponent(Component comp, Object constraints) {
            if (constraints instanceof TimeEntry) {
                mapConstraints.put(comp, (TimeEntry) constraints);
            } else {
                throw new IllegalArgumentException(
                                constraints == null ? "Null is not a valid constraint"
                                : constraints.getClass().getName() + " is not a valid TimeEntry constraint"
                );
            }
        }

        @Override
        public Dimension maximumLayoutSize(Container target) {
            return preferredLayoutSize(target);
        }

        @Override
        public float getLayoutAlignmentX(Container target) {
            return 0.5f;
        }

        @Override
        public float getLayoutAlignmentY(Container target) {
            return 0.5f;
        }

        @Override
        public void invalidateLayout(Container target) {
        }

        @Override
        public void addLayoutComponent(String name, Component comp) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void removeLayoutComponent(Component comp) {
            mapConstraints.remove(comp);
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return new Dimension(colWidth * (24 - 8), rowHeight);
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return preferredLayoutSize(parent);
        }

        @Override
        public void layoutContainer(Container parent) {
            Insets insets = parent.getInsets();
            int width = parent.getWidth() - (insets.left + insets.right);
            int height = rowHeight;

            int hourWidth = colWidth;
            int offset = 8;

            for (Component comp : mapConstraints.keySet()) {
                TimeEntry te = mapConstraints.get(comp);
                double startTime = te.getStartTime();
                double duration = te.getDuration();

                startTime -= offset;

                int x = (int) Math.round(startTime * hourWidth);
                int unitWidth = (int) Math.round(duration * hourWidth);
                comp.setLocation(x, insets.top);
                comp.setSize(unitWidth, height);
            }
        }

    }

    public enum WorkType {

        WORK(WORKING_HOURS_COLOR),
        LUNCH(LUNCH_HOURS_COLOR),
        OTHER(OTHER_HOURS_COLOR);

        private Color color;

        private WorkType(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

    }

    public interface TimeEntry {

        public WorkType getType();

        public double getStartTime();

        public double getDuration();
    }

    public interface TimeSheet extends Iterable<TimeEntry> {

        public String getName();

        public int size();

        public TimeEntry get(int index);

        public double getWorkingHours();

    }

    public interface TimeSheetReport extends Iterable<TimeSheet> {

        public int size();

        public TimeSheet get(int index);

    }

    public class DefaultTimeEntry implements TimeEntry {

        private final double startTime;
        private final double endTime;
        private final WorkType workType;

        public DefaultTimeEntry(WorkType type, double startTime, double endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.workType = type;
        }

        @Override
        public double getStartTime() {
            return startTime;
        }

        public double getEndTime() {
            return endTime;
        }

        @Override
        public double getDuration() {
            return endTime - startTime;
        }

        @Override
        public WorkType getType() {
            return workType;
        }

    }

    public class DefaultTimeSheet implements TimeSheet {

        private final List<TimeEntry> timeEntries;
        private final String name;

        public DefaultTimeSheet(String name) {
            this.name = name;
            timeEntries = new ArrayList<>(25);
        }

        public TimeSheet add(TimeEntry te) {
            timeEntries.add(te);
            return this;
        }

        @Override
        public Iterator<TimeEntry> iterator() {
            return timeEntries.iterator();
        }

        @Override
        public int size() {
            return timeEntries.size();
        }

        @Override
        public TimeEntry get(int index) {
            return timeEntries.get(index);
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public double getWorkingHours() {
            double time = 0;
            for (TimeEntry te : this) {
                switch (te.getType()) {
                    case WORK:
                        time += te.getDuration();
                        break;
                }
            }
            return time;
        }

    }

    public class DefaultTimeSheetReport implements TimeSheetReport {

        private final List<TimeSheet> timeSheets;

        public DefaultTimeSheetReport() {
            timeSheets = new ArrayList<>(25);
        }

        public DefaultTimeSheetReport add(TimeSheet ts) {
            timeSheets.add(ts);
            return this;
        }

        @Override
        public int size() {
            return timeSheets.size();
        }

        @Override
        public TimeSheet get(int index) {
            return timeSheets.get(index);
        }

        @Override
        public Iterator<TimeSheet> iterator() {
            return timeSheets.iterator();
        }

    }

}