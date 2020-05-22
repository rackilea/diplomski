import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TestTableModel {

    private ResultSet resultSet = null;

    public TestTableModel() throws SQLException {
        initDB();

        JTable table = new JTable(getModel(resultSet));
        JScrollPane scroll = new JScrollPane(table);

        JFrame frame = new JFrame("Test Table Model");
        frame.add(scroll);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    TestTableModel testTableModel = new TestTableModel();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private DefaultTableModel getModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        Vector<String> columnNames = new Vector<>();

        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
            System.out.println("ColumnNames " + columnNames);
        }
        DefaultTableModel dataModel = new DefaultTableModel(columnNames, 0);

        while (resultSet.next()) {
            Vector<String> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(resultSet.getString(columnIndex));
            }
            dataModel.addRow(vector);
        }


        return dataModel;
    }

    private void initDB() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/...", "...", "...");
            ps = conn.prepareStatement("SELECT * FROM city");
            resultSet = ps.executeQuery();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } 

    }
}