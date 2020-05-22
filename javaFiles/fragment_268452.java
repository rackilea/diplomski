import java.sql.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class DBHandler extends AbstractTableModel {

    private static Connection connection;
    private static Statement stmt;
    List<String> columnHeaders;
    List<List<String>> tableData;
    static int id;
    public static int autokey = -1;
    static String[] contactList;
    static ArrayList<String> senders = new ArrayList<String>();

    public DBHandler() {
        List rowData = null;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String sourceURL = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=olympic.mdb;";
            connection = DriverManager.getConnection(sourceURL, "admin", "");
            stmt = connection.createStatement();
            String sql = "Select * FROM senderTable";
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();

            int count = md.getColumnCount();
            columnHeaders = new ArrayList<String>();
            tableData = new ArrayList<List<String>>();
            for (int i = 1; i <= count; i++) {
                columnHeaders.add(md.getColumnName(i));
            }
            while (rs.next()) {
                rowData = new ArrayList<String>();
                for (int i = 1; i <= count; i++) {
                    rowData.add(rs.getObject(i));
                }
                tableData.add(rowData);
            }


        } catch (Exception e) {
            System.out.println("There is an connection error:  " + e);
        }
    }

    public int getColumnCount() {
        return columnHeaders.size();
    }

    public int getRowCount() {
        return tableData.size();
    }

    public Object getValueAt(int row, int column) {
        ArrayList rowData = (ArrayList) (tableData.get(row));
        return rowData.get(column);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return (String) (columnHeaders.get(column));
    }

    public static ArrayList getSend() {

        try {
            ResultSet res = stmt.executeQuery("SELECT * FROM senderTable");
            while (res.next()) {
                String send = res.getString(2);
                senders.add(send);
            }
        } catch (Exception e) {
            System.out.println("getSend " + e);
            return null;
        }
        return senders;
    }

    public static void close() {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println("close" + e);
        }
    }
}