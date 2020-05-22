import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.concurrent.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

public class ChangeNotifiersOnEvent extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;
    private boolean runProcess = true;
    private Random random = new Random();
    private javax.swing.Timer timerRun;
    private Executor executor = Executors.newCachedThreadPool();
    private String[] columnNames = {"Source", "Hit", "Last", "Ur_Diff"};
    private JTable table;
    private Object[][] data = {{"Swing Timer", 2.99, 5, 1.01},
        {"Swing Worker", 7.10, 5, 1.010}, {"TableModelListener", 25.05, 5, 1.01}};
    private DefaultTableModel model = new DefaultTableModel(data, columnNames);

    public ChangeNotifiersOnEvent() {
        table = new JTable(model) {

            private static final long serialVersionUID = 1L;

            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        model.addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent tme) {
                if (tme.getType() == TableModelEvent.UPDATE) {
                    if (tme.getColumn() == 1 && tme.getLastRow() == 2) {
                        double dbl = ((Double) table.getModel().getValueAt(2, 1))
                                - ((Integer) table.getModel().getValueAt(2, 2));
                        table.getModel().setValueAt(dbl, 2, 3);
                    } else if (tme.getColumn() == 1 && tme.getLastRow() == 0) {
                        prepareUpdateTableCell();
                    } else if (tme.getColumn() == 1 && tme.getLastRow() == 1) {
                        executor.execute(new MyTask(MyTask.UPDATE_TABLE_COLUMN));
                    }
                }
            }
        });
        table.setRowHeight(30);
        table.setFont(new Font("Serif", Font.BOLD, 20));
        table.getColumnModel().getColumn(0).setPreferredWidth(180);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        new Thread(this).start();
    }

    private void prepareUpdateTableCell() {
        timerRun = new javax.swing.Timer(10, UpdateTableCell());
        timerRun.setRepeats(false);
        timerRun.start();
    }

    private Action UpdateTableCell() {
        return new AbstractAction("Update Table Cell") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                double dbl = ((Double) table.getModel().getValueAt(0, 1))
                        - ((Integer) table.getModel().getValueAt(0, 2));
                table.getModel().setValueAt(dbl, 0, 3);
            }
        };
    }

    @Override
    public void run() {
        while (runProcess) {
            try {
                Thread.sleep(250);
            } catch (Exception e) {
                e.printStackTrace();
            }
            changeTableValues();
        }
    }

    private void changeTableValues() {
        Runnable doRun = new Runnable() {

            @Override
            public void run() {
                table.getModel().setValueAt(random.nextInt(128) + random.nextDouble(), 0, 1);
                table.getModel().setValueAt(random.nextInt(256) + random.nextDouble(), 1, 1);
                table.getModel().setValueAt(random.nextInt(512) + random.nextDouble(), 2, 1);

                table.getModel().setValueAt(random.nextInt(128), 0, 2);
                table.getModel().setValueAt(random.nextInt(128), 1, 2);
                table.getModel().setValueAt(random.nextInt(128), 2, 2);
            }
        };
        SwingUtilities.invokeLater(doRun);
    }

    private class MyTask extends SwingWorker<Void, Integer> {

        private static final String UPDATE_TABLE_COLUMN = "update";
        private String namePr;
        private double dbl;

        MyTask(String str) {
            this.namePr = str;
        }

        @Override
        protected Void doInBackground() throws Exception {
            dbl = ((Double) table.getModel().getValueAt(1, 1))
                    - ((Integer) table.getModel().getValueAt(1, 2));
            return null;
        }

        @Override
        protected void done() {
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    table.getModel().setValueAt(dbl, 1, 3);
                }
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                ChangeNotifiersOnEvent frame = new ChangeNotifiersOnEvent();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setLocation(150, 150);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}