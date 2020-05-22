import java.awt.BorderLayout;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * @see https://stackoverflow.com/q/43161033/230513
 * @see https://stackoverflow.com/a/34742409/230513
 * @see https://stackoverflow.com/a/24762078/230513
 */
public class WorkerTest {

    private static final int N = 256;
    private static final String URL = "jdbc:h2:mem:test";
    private static final Random r = new Random();

    private JPanel contentPane;
    private static JTable tblSchedule;
    private JScrollPane scrollSchedTable;
    private JDBCModel model;
    private JPanel panel;
    private JTextField textField;

    private static TableRowSorter<TableModel> rowSorter;

    private void display() {

        createTestDatabase(N);  //Create the Test Database

        //Create the GUI
        JFrame f = new JFrame("WorkerTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(100, 100, 780, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        f.setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        scrollSchedTable = new JScrollPane();
        scrollSchedTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contentPane.add(scrollSchedTable);

        tblSchedule = new JTable();
        tblSchedule.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblSchedule.setShowHorizontalLines(true);
        tblSchedule.setShowVerticalLines(true);
        tblSchedule.setFillsViewportHeight(true);
        model = new JDBCModel(getConnection(), "select * from city");
        tblSchedule.setModel(model);
        rowSorter = new TableRowSorter<TableModel>(model);
        tblSchedule.setRowSorter(rowSorter);
        scrollSchedTable.setViewportView(tblSchedule);

        panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(0, 0));

        textField = new JTextField();
        panel.add(textField, BorderLayout.EAST);
        textField.setColumns(10);

        panel.add(model.jpb, BorderLayout.CENTER);

        textField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = textField.getText().trim();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = textField.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String text = textField.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

        });
        f.setVisible(true);
    }

    private static class Row {

        String lname;
        String fname;
        String monTime;
        String tueTime;
        String wedTime;
        String thuTime;
        String friTime;
        String satTime;
        String sunTime;
        String totalTime;
    }

    private static class JDBCModel extends AbstractTableModel {

        private final JProgressBar jpb = new JProgressBar();
        private static final long serialVersionUID = 1L;
        private final List<Row> data = new ArrayList<>();
        private ResultSet rs = null;
        private ResultSetMetaData meta;

        public JDBCModel(Connection conn, String query) {
            try {
                Statement s = conn.createStatement();
                rs = s.executeQuery(query);
                meta = rs.getMetaData();
                JDBCWorker worker = new JDBCWorker();
                jpb.setIndeterminate(true);
                worker.execute();

            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 10;
        }

        @Override
        public Object getValueAt(int rowIndex, int colIndex) {
            Row row = data.get(rowIndex);
            switch (colIndex) {
                case 0:
                    return row.lname;
                case 1:
                    return row.fname;
                case 2:
                    return row.monTime;
                case 3:
                    return row.tueTime;
                case 4:
                    return row.wedTime;
                case 5:
                    return row.thuTime;
                case 6:
                    return row.friTime;
                case 7:
                    return row.satTime;
                case 8:
                    return row.sunTime;
                case 9:
                    return row.totalTime;
            }
            return null;
        }

        @Override
        public String getColumnName(int colIndex) {
            String name = null;
            switch (colIndex) {
                case 0:
                    name = "Last Name";
                    return name;
                case 1:
                    name = "First Name";
                    return name;
                case 2:
                    name = "Monday";
                    return name;
                case 3:
                    name = "Tuesday";
                    return name;
                case 4:
                    name = "Wednesday";
                    return name;
                case 5:
                    name = "Thursday";
                    return name;
                case 6:
                    name = "Friday";
                    return name;
                case 7:
                    name = "Saturday";
                    return name;
                case 8:
                    name = "Sunday";
                    return name;
                case 9:
                    name = "Total";
                    return name;
            }
            return name;
        }

        private class JDBCWorker extends SwingWorker<List<Row>, Row> {

            @Override
            protected List<Row> doInBackground() {
                try {
                    while (rs.next()) {
                        Row r = new Row();
                        Integer total = 0;
                        r.lname = rs.getString(2);
                        r.fname = rs.getString(1);
                        r.monTime = String.valueOf(rs.getInt(3) + " - " + rs.getInt(4));
                        total += rs.getInt(4) - rs.getInt(3);
                        r.tueTime = String.valueOf(rs.getInt(5) + " - " + rs.getInt(6));
                        total += rs.getInt(6) - rs.getInt(5);
                        r.wedTime = String.valueOf(rs.getInt(7) + " - " + rs.getInt(8));
                        total += rs.getInt(8) - rs.getInt(7);
                        r.thuTime = String.valueOf(rs.getInt(9) + " - " + rs.getInt(10));
                        total += rs.getInt(10) - rs.getInt(9);
                        r.friTime = String.valueOf(rs.getInt(11) + " - " + rs.getInt(12));
                        total += rs.getInt(12) - rs.getInt(11);
                        r.satTime = String.valueOf(rs.getInt(13) + " - " + rs.getInt(14));
                        total += rs.getInt(14) - rs.getInt(13);
                        r.sunTime = String.valueOf(rs.getInt(15) + " - " + rs.getInt(16));
                        total += rs.getInt(16) - rs.getInt(15);
                        r.totalTime = String.valueOf(total);
                        publish(r);
                    }
                } catch (SQLException e) {
                    e.printStackTrace(System.err);
                }
                return data;
            }

            @Override
            protected void process(List<Row> chunks) {
                int n = getRowCount() + 1;
                System.out.println("Row Count = " + n);
                System.out.println("Chunks Size = " + chunks.size());
                for (Row row : chunks) {
                    data.add(row);
                }
                fireTableDataChanged();
            }

            @Override
            protected void done() {
                jpb.setIndeterminate(false);
                jpb.setValue(100);
            }
        }
    }

//Creates the Test DB with test names and working hours
    private static void createTestDatabase(int n) {
        ThreadLocalRandom r = ThreadLocalRandom.current();
        Connection conn = getConnection();
        try {
            Statement st = conn.createStatement();
            st.execute("create table city(fname varchar(10), lname varchar(10), mons int(2), mone int(2), tues int(2), tuee int(2), weds int(2), wede int(2), thus int(2), thue int(2), fris int(2), frie int(2), sats int(2), sate int(2), suns int(2), sune int(2))");
            Random gen = new Random();
            PreparedStatement ps = conn.prepareStatement(
                "insert into city values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            for (int i = 0; i < n; i++) {
                ps.setString(1, "First" + i);
                ps.setString(2, "Last" + i);
                ps.setInt(3, r.nextInt(6, 12));
                ps.setInt(4, r.nextInt(13, 22));
                ps.setInt(5, r.nextInt(6, 12));
                ps.setInt(6, r.nextInt(13, 22));
                ps.setInt(7, r.nextInt(6, 12));
                ps.setInt(8, r.nextInt(13, 22));
                ps.setInt(9, r.nextInt(6, 12));
                ps.setInt(10, r.nextInt(13, 22));
                ps.setInt(11, r.nextInt(6, 12));
                ps.setInt(12, r.nextInt(13, 22));
                ps.setInt(13, r.nextInt(6, 12));
                ps.setInt(14, r.nextInt(13, 22));
                ps.setInt(15, r.nextInt(6, 12));
                ps.setInt(16, r.nextInt(13, 22));
                ps.execute();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    private static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, "", "");
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        return null;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new WorkerTest()::display);
    }
}