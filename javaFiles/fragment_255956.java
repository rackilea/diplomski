import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Random;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.*;

public class TableWithTimer implements ActionListener, Runnable {

    private static final long serialVersionUID = 1L;
    private JFrame frame = new JFrame();
    private JScrollPane scroll = new JScrollPane();
    private JTable myTable;
    private JPanel buttonPanel = new JPanel();
    private JButton startButton = new JButton("Start Thread to Update Table");
    private JButton stopButton = new JButton("Stop Thread for Update Table");
    private JButton newButton = new JButton("Load new Data to Table");
    private int count = 0;
    private int delay = 3;
    private javax.swing.Timer timer = null;
    private boolean runProcess;
    private int row = 0;
    private int column = 0;
    private String value = "Amnd";
    private int amndValue = 0;
    private String valueAt = "";
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    private String[] head = {"One", "Two", "Three", "Four", "Five", "Six"};
    private String[][] data = new String[25][6];

    public TableWithTimer() {
        myTable = new TableBackroundPaint0(data, head);
        myTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        myTable.setRowSelectionAllowed(false);
        myTable.setColumnSelectionAllowed(true);
        //myTable.setCellSelectionEnabled(true);

        myTable.setGridColor(Color.gray);
        myTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        final TableCellRenderer cellRendener = myTable.getTableHeader().getDefaultRenderer();
        myTable.getTableHeader().setDefaultRenderer(new TableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) cellRendener.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);
                label.setBackground(Color.orange);
                label.setForeground(Color.darkGray);
                label.setFont(new Font("SansSerif", Font.BOLD, 12));
                label.setBorder(BorderFactory.createCompoundBorder(label.getBorder(),
                        BorderFactory.createEmptyBorder(0, 5, 0, 0)));
                label.setHorizontalAlignment(SwingConstants.LEFT);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                if ((label.getText().equals("First")) || (label.getText().equals("Second"))) {
                    label.setForeground(Color.red);
                }
                if ((label.getText().equals("Day")) || (label.getText().equals("Month")) || (label.getText().equals("Year"))) {
                    label.setForeground(Color.blue);
                }
                if ((label.getText().equals("Time"))) {
                    label.setForeground(Color.green);
                }
                return label;
            }
        });
        TableColumnModel cm = myTable.getColumnModel();
        for (int column1 = 0; column1 < cm.getColumnCount(); column1++) {
            TableColumn colLeft1 = cm.getColumn(column1);
            cm.getColumn(column1).setWidth(140);
            cm.getColumn(column1).setPreferredWidth(140);
        }
        //myTable.setFillsViewportHeight(true); // apply paintComponent for whole Viewport
        JButton cornerButtonTop = new JButton();
        cornerButtonTop.setBackground(scroll.getViewport().getBackground());
        JButton cornerButtonBottom = new JButton();
        cornerButtonBottom.setOpaque(false);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, cornerButtonTop);
        scroll.setCorner(JScrollPane.LOWER_RIGHT_CORNER, cornerButtonBottom);
        scroll.setViewportView(myTable);
        scroll.setMinimumSize(new Dimension(600, 400));
        scroll.setMaximumSize(new Dimension(900, 600));
        scroll.setPreferredSize(new Dimension(850, 430));
        frame.add(scroll, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(1, 4, 10, 10));
        startButton.addActionListener(this);
        startButton.setEnabled(false);
        stopButton.addActionListener(this);
        stopButton.setEnabled(false);
        JButton hideButton = new JButton();
        newButton.addActionListener(this);
        newButton.setEnabled(false);
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(hideButton);
        buttonPanel.add(newButton);
        hideButton.setVisible(false);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        frame.pack();
        frame.setVisible(true);
        start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            runProcess = true;
            new Thread(this).start();
            myTable.requestFocus();
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
        } else if (e.getSource() == stopButton) {
            scroll.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            runProcess = false;
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            newButton.setEnabled(true);
        } else if (e.getSource() == newButton) {
            runProcess = false;
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            newButton.setEnabled(false);
            addNewData();
        }
    }

    public void addNewData() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                TableModel model = myTable.getModel();
                for (int j = 0; j < model.getRowCount(); j++) {
                    int column = model.getColumnCount();
                    for (int i = 0; i < column; i++) {
                        model.setValueAt("Deleted", j, i);
                    }
                }
                startNewData();
            }
        });
    }

    private void start() {
        scroll.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        timer = new javax.swing.Timer(delay * 100, updateCol());
        timer.start();
    }

    private void startNewData() {
        scroll.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        count = 0;
        timer = new javax.swing.Timer(1500, updateCol());
        timer.start();
    }

    @Override
    public void run() {
        scroll.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        count = 0;
        Random random = new Random();
        while (runProcess) {
            row = random.nextInt(myTable.getRowCount());
            column = random.nextInt(myTable.getColumnCount());
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    try {
                        amndValue++;
                        valueAt = ((myTable.getValueAt(row, column)).toString());
                        if (!(valueAt.startsWith("A"))) {
                            count++;
                            if (count == ((25 * 6))) {
                                JOptionPane.showMessageDialog(myTable, " Update done ");
                                scroll.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                runProcess = false;
                            }
                            java.util.Date date = new java.util.Date();
                            String dateTime = sdf.format(date.getTime());
                            myTable.setValueAt((value + " " + String.valueOf(amndValue) + " at: " + dateTime), row, column);
                            //myTable.setValueAt(new Integer(1), row, column); // please uncoment for generate misstype error on EDT
                            myTable.changeSelection(row, column, false, false);
                            System.out.println("update cycle with value :"
                                    + (value + " " + String.valueOf(amndValue) + " at: " + dateTime) + ", table row :" + row
                                    + ", table column " + column);
                        }
                    } catch (Exception e) {
                        runProcess = false;
                        System.out.println("Error for update JTable cell");
                        e.printStackTrace();
                    }
                }
            });
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Action updateCol() {
        return new AbstractAction("text load action") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("updating row " + (count + 1));
                TableModel model = myTable.getModel();
                int cols = model.getColumnCount();
                int row = 0;
                for (int j = 0; j < cols; j++) {
                    row = count;
                    myTable.changeSelection(row, 0, false, false);
                    timer.setDelay(200);
                    Object value = "row " + (count + 1) + " item " + (j + 1);
                    model.setValueAt(value, count, j);
                }
                count++;
                if (count >= myTable.getRowCount()) {
                    myTable.changeSelection(0, 0, false, false);
                    timer.stop();
                    System.out.println("update cycle completed");
                    myTable.clearSelection();
                    startButton.setEnabled(true);
                    newButton.setEnabled(true);
                    scroll.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
            }
        };
    }

    public static void main(String args[]) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
        TableWithTimer tableWithTimer = new TableWithTimer();
    }
}

class TableBackroundPaint0 extends JTable {

    private static final long serialVersionUID = 1L;

    TableBackroundPaint0(Object[][] data, Object[] head) {
        super(data, head);
        setOpaque(false);
        ((JComponent) getDefaultRenderer(Object.class)).setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        Color background = new Color(168, 210, 241);
        Color controlColor = new Color(230, 240, 230);
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) g;
        Paint oldPaint = g2.getPaint();
        g2.setPaint(new GradientPaint(0, 0, background, width, 0, controlColor));
        g2.fillRect(0, 0, width, height);
        g2.setPaint(oldPaint);
        for (int row : getSelectedRows()) {
            Rectangle start = getCellRect(row, 0, true);
            Rectangle end = getCellRect(row, getColumnCount() - 1, true);
            g2.setPaint(new GradientPaint(start.x, 0, controlColor, (int) ((end.x + end.width - start.x) * 1.25), 0, Color.orange));
            g2.fillRect(start.x, start.y, end.x + end.width - start.x, start.height);
        }
        super.paintComponent(g);
    }
}