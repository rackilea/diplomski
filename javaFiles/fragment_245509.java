import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.swing.*;
import javax.swing.table.*;

/** @see https://stackoverflow.com/questions/7054627 */
public class TableWithExecutor extends JFrame {

    private static final int delay = 1000;
    private static final DateFormat df = DateFormat.getTimeInstance();
    private String[] columnNames = {"Product", "Availability"};
    private Object[][] data = {columnNames, columnNames, columnNames};
    private DefaultTableModel model;
    private JTable table;
    private Executor executor = Executors.newCachedThreadPool();
    private Timer timer;

    public TableWithExecutor() {
        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model) {

            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        table.setDefaultRenderer(Date.class, new DefaultTableCellRenderer() {

            @Override
            protected void setValue(Object value) {
                setText((value == null) ? "" : df.format(value));
            }
        });
        table.setPreferredScrollableViewportSize(new Dimension(200, 100));
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        timer = new Timer(delay, startCycle());
        timer.setRepeats(true);
        timer.start();
    }

    private Action startCycle() {
        return new AbstractAction(MyTask.STARTSCHEDULE) {

            @Override
            public void actionPerformed(ActionEvent e) {
                executor.execute(new MyTask(MyTask.STARTSCHEDULE));
            }
        };
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                TableWithExecutor frame = new TableWithExecutor();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private class MyTask extends SwingWorker<List<DateRecord>, DateRecord> {

        private static final String STARTSCHEDULE = "StartSchedule";
        private String name = STARTSCHEDULE;

        MyTask(String name) {
            this.name = name;
            addPropertyChangeListener(new TaskListener(name));
        }

        @Override
        protected List<DateRecord> doInBackground() throws Exception {
            for (int row = 0; row < model.getRowCount(); row++) {
                Date date = new Date();
                date.setTime(date.getTime() + row * 1000);
                publish(new DateRecord(row, date));
            }
            return null;
        }

        @Override
        protected void process(List<DateRecord> chunks) {
            for (DateRecord dr : chunks) {
                model.setValueAt(dr.date, dr.rowNumber, 1);
            }
        }

        @Override
        protected void done() {
            try {
                get();
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }
    }

    private static class DateRecord {

        private int rowNumber;
        private Date date;

        public DateRecord(int recordNumber, Date date) {
            this.rowNumber = recordNumber;
            this.date = date;
        }
    }

    private static class TaskListener implements PropertyChangeListener {

        private String name;

        TaskListener(String name) {
            this.name = name;
        }

        @Override
        public void propertyChange(PropertyChangeEvent e) {
            System.out.println(name + ": "
                + e.getOldValue() + " -> " + e.getNewValue());
        }
    }
}