import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarGraph {

    public int count = 0, count1 = 0, count2 = 0, count3 = 0, count4 = 0;
    public int contstatus = 2;
    public int date, year, mon, fn, show = 0, finalday, leapcn = 0, task = 0;
    String startdte, enddte, monthweek, leavedates = "", nneed = "", year4enab, month4enab, days;
    ChartFrame frame;
    public static int st = 0;
    JButton left = new JButton("<");
    JButton right = new JButton(">");
    JComboBox month = new JComboBox();
    JSpinner yearspin = new javax.swing.JSpinner();
    JLabel monthLabel = new javax.swing.JLabel();
    JLabel yearLabel = new javax.swing.JLabel();
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    BarGraph() {
        task = 1;
        Calendar cal;

        left.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        left.setRequestFocusEnabled(false);
        left.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftActionPerformed(evt);
            }
        });


        right.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        right.setRequestFocusEnabled(false);
        right.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightActionPerformed(evt);
            }
        });

        month.setMaximumRowCount(12);
        month.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
        month.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        month.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                monthItemStateChanged(evt);
            }
        });

        yearspin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yearspin.setValue(year);
        yearspin.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                yearspinStateChanged(evt);
            }
        });

        monthLabel.setBackground(new java.awt.Color(255, 255, 255));
        monthLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        monthLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monthLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.black, null, null));
        monthLabel.setOpaque(true);
        monthLabel.setText("SEPTEMBER");

        yearLabel.setBackground(new java.awt.Color(255, 255, 255));
        yearLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        yearLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yearLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.black, null, null));
        yearLabel.setOpaque(true);
        yearLabel.setText("2013");
        cal = new GregorianCalendar();
        year = cal.get(Calendar.YEAR);
        mon = cal.get(Calendar.MONTH);
        date = cal.get(Calendar.DATE);
        yearspin.setValue(year);
        month.setSelectedIndex(mon);
        calendar(year, mon);
        month4enab = getMonth(monthLabel.getText());
        year4enab = yearLabel.getText();

        startdte = year4enab + "-" + month4enab + "-01";
        enddte = year4enab + "-" + month4enab + "-" + finalday;
    }

    public static void main(String[] args) {
        new BarGraph().showBar();

    }

    private void leftActionPerformed(ActionEvent evt) {
        show = 0;
        if (mon == 0) {
            year--;
            mon = 11;
        } else {
            mon--;
        }
        yearspin.setValue(year);
        month.setSelectedIndex(mon);
        display();
        calendar(year, mon);
        displayCalendar();
        updateDataset();
    }

    private void rightActionPerformed(ActionEvent evt) {
        show = 0;
        if (mon == 11) {
            year++;
            mon = 0;
        } else {
            mon++;
        }
        yearspin.setValue(year);
        month.setSelectedIndex(mon);
        display();
        calendar(year, mon);
        displayCalendar();
        updateDataset();
    }

    private void displayCalendar() {
        month4enab = getMonth(monthLabel.getText());
        year4enab = yearLabel.getText();
        startdte = year4enab + "-" + month4enab + "-01";
        enddte = year4enab + "-" + month4enab + "-" + finalday;
    }

    private void monthItemStateChanged(ItemEvent evt) {
        show = 0;
        String s = (String) month.getSelectedItem();

        if ("January".equals(s)) {
            mon = 0;
        }
        if ("February".equals(s)) {
            mon = 1;
        }
        if ("March".equals(s)) {
            mon = 2;
        }
        if ("April".equals(s)) {
            mon = 3;
        }
        if ("May".equals(s)) {
            mon = 4;
        }
        if ("June".equals(s)) {
            mon = 5;
        }
        if ("July".equals(s)) {
            mon = 6;
        }
        if ("August".equals(s)) {
            mon = 7;
        }
        if ("September".equals(s)) {
            mon = 8;
        }
        if ("October".equals(s)) {
            mon = 9;
        }
        if ("November".equals(s)) {
            mon = 10;
        }
        if ("December".equals(s)) {
            mon = 11;
        }
        display();
        calendar(year, mon);
        updateDataset();
    }

    private void yearspinStateChanged(ChangeEvent evt) {
        show = 0;
        year = (Integer) yearspin.getValue();
        display();
        calendar(year, mon);
        updateDataset();
    }

    public void display() {
        String month = "", day = "";
        if (mon < 9) {
            month = "0" + (mon + 1);
        } else {
            month = "" + (mon + 1);
        }
        if (nneed.length() < 2) {
            day = "0" + nneed;
        } else {
            day = "" + nneed;
        }

        String datss = year + "-" + (month) + "-" + day;
        switch (mon) {
            case 0:
                monthLabel.setText("JANUARY");
                break;
            case 1:
                monthLabel.setText("FEBRUARY");
                break;
            case 2:
                monthLabel.setText("MARCH");
                break;
            case 3:
                monthLabel.setText("APRIL");
                break;
            case 4:
                monthLabel.setText("MAY");
                break;
            case 5:
                monthLabel.setText("JUNE");
                break;
            case 6:
                monthLabel.setText("JULY");
                break;
            case 7:
                monthLabel.setText("AUGUST");
                break;
            case 8:
                monthLabel.setText("SEPTEMBER");
                break;
            case 9:
                monthLabel.setText("OCTOBER");
                break;
            case 10:
                monthLabel.setText("NOVEMBER");
                break;
            case 11:
                monthLabel.setText("DECEMBER");
                break;

        }
        yearLabel.setText(String.valueOf(year));
    }

    public void calendar(int year, int mon) {
        int year1 = year;
        int count1 = 1, fun = 0, day, day1 = 0, key = 0, k = -1, s = 1, ck = 2, cheak, y = 0;
        day1 = year % 100;
        fun = 1 + (day1 / 4);
        switch (mon) {
            case 0:
                key = 1;
                k = -1;
                break;
            case 1:
                key = 4;
                k = 0;
                break;
            case 2:
                key = 4;
                k = 0;
                break;
            case 3:
                key = 0;
                k = 0;
                break;
            case 4:
                key = 2;
                k = 0;
                break;
            case 5:
                key = 5;
                k = 0;
                break;
            case 6:
                key = 0;
                k = 0;
                break;
            case 7:
                key = 3;
                k = 0;
                break;
            case 8:
                key = 6;
                k = 0;
                break;
            case 9:
                key = 1;
                k = 0;
                break;
            case 10:
                key = 4;
                k = 0;
                break;
            case 11:
                key = 6;
                k = 0;
                break;
        }

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            k = -1;
            day = 29;
            leapcn = 0;
            if (mon == 0 || mon == 1) {
                leapcn = 1;
            }
        } else {
            k = 0;
            day = 28;
            leapcn = 1;
        }

        if (year >= 2000) {
            y = 6;
        }
        if (year <= 1900 && year > 2000) {
            y = 0;

        }
        fun = fun + key + k + y;
        fun = (fun + day1) % 7;
        if (fun == 0) {
            fun = 7;
        }
        if (mon == 0 || mon == 2 || mon == 4 || mon == 6 || mon == 7 || mon == 9 || mon == 11) {
            day = 31;
        }
        if (mon == 3 || mon == 5 || mon == 8 || mon == 10) {
            day = 30;
        }
        finalday = day;
        System.out.println("DAYS IN THIS MONTHS:" + finalday);
        cheak = fun + 1;
        s++;
    }

    public static String getMonth(String s) {
        String mont = "56";
        if ("January".equalsIgnoreCase(s)) {
            mont = "01";
        } else if ("February".equalsIgnoreCase(s)) {
            mont = "02";
        } else if ("March".equalsIgnoreCase(s)) {
            mont = "03";
        } else if ("April".equalsIgnoreCase(s)) {
            mont = "04";
        } else if ("May".equalsIgnoreCase(s)) {
            mont = "05";
        } else if ("June".equalsIgnoreCase(s)) {
            mont = "06";
        } else if ("July".equalsIgnoreCase(s)) {
            mont = "07";
        } else if ("August".equalsIgnoreCase(s)) {
            mont = "08";
        } else if ("September".equalsIgnoreCase(s)) {
            mont = "09";
        } else if ("October".equalsIgnoreCase(s)) {
            mont = "10";
        } else if ("November".equalsIgnoreCase(s)) {
            mont = "11";
        } else if ("December".equalsIgnoreCase(s)) {
            mont = "12";
        }
        return mont;
    }

    private void showBar() {
        for (int i = 1; i <= finalday; i++) {
            dataset.setValue(i, "Marks", "" + i);
        }
        JFreeChart chart = ChartFactory.createBarChart(" ", "Student", "Marks",
            dataset, PlotOrientation.VERTICAL, false, true, false);
        chart.setBackgroundPaint(Color.WHITE);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(221, 223, 238));
        plot.setRangeGridlinePaint(Color.white);
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(231, 175, 61));
        renderer.setSeriesPaint(1, Color.green);
        renderer.setDrawBarOutline(false);
        renderer.setShadowVisible(false);
        chart.setBackgroundPaint(Color.WHITE);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLUE);

        frame = new ChartFrame("Bar Chart", chart);
        frame.add(month);
        frame.add(left);
        frame.add(right);
        frame.add(yearspin);
        frame.add(monthLabel);
        frame.add(yearLabel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private void updateDataset() {
        dataset.clear();
        for (int i = 1; i <= finalday; i++) {
            dataset.setValue(i, "Marks", "" + i);
        }
    }
}