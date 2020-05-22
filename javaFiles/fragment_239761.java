import java.awt.BorderLayout;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.beans.Statement;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.ResultSetMetaData;
    import java.sql.SQLException;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Vector;

    import javax.swing.JFrame;
    import javax.swing.JMenuItem;
    import javax.swing.JPanel;
    import javax.swing.JPopupMenu;
    import javax.swing.JScrollPane;
    import javax.swing.JTable;
    import javax.swing.SwingUtilities;
    import javax.swing.table.DefaultTableModel;

    public class JTablePopupMenuExample extends JFrame implements ActionListener {


        private JTable table;
        private DefaultTableModel tableModel; 
        private JPopupMenu popupMenu;
        private JMenuItem menuItemAdd;
        private JMenuItem menuItemRemove;
        private JMenuItem menuItemRemoveAll;
        List<SentMessagesTable> msgList;

        public JTablePopupMenuExample() throws Exception{
            super("JTable Popup Menu Example");

            // sample table data
            String[] columnNames = new String[] {"id", "receiver", "sender", "msg_text", "status", "x_date"};



            msgList = new ArrayList<SentMessagesTable>();


            ResultSet rs = getTableRows();  


            while (rs.next()) {

                SentMessagesTable msg = new SentMessagesTable();

                msg.setId(rs.getInt("id"));
                msg.setReceiver(rs.getString("receiver"));
                msg.setSender(rs.getString("sender"));
                msg.setMsgText(rs.getString("msg_text"));
                msg.setStatus(rs.getString("status"));
                msg.setxDate(rs.getString("x_date"));

                msgList.add(msg);

            }

            String[][] rowDataTable = new String[34400][6];

            for(int i = 0 ; i < msgList.size();i++) {
                //burda jtable listesini doldur
                rowDataTable[i][0] = String.valueOf(msgList.get(i).getId());
                rowDataTable[i][1] = msgList.get(i).getReceiver();
                rowDataTable[i][2] = msgList.get(i).getSender();
                rowDataTable[i][3] = msgList.get(i).getMsgText();
                rowDataTable[i][4] = msgList.get(i).getStatus();
                rowDataTable[i][5] = msgList.get(i).getxDate(); 
            }

            // constructs the table with sample data
            tableModel = new DefaultTableModel(rowDataTable, columnNames);
            table = new JTable(tableModel);

            // constructs the popup menu
            popupMenu = new JPopupMenu();
            menuItemAdd = new JMenuItem("Add New Row");
            menuItemRemove = new JMenuItem("Remove Current Row");
            menuItemRemoveAll = new JMenuItem("Remove All Rows");

            menuItemAdd.addActionListener(this);
            menuItemRemove.addActionListener(this);
            menuItemRemoveAll.addActionListener(this);

            popupMenu.add(menuItemAdd);
            popupMenu.add(menuItemRemove);
            popupMenu.add(menuItemRemoveAll);

            // sets the popup menu for the table
            table.setComponentPopupMenu(popupMenu);

            table.addMouseListener(new TableMouseListener(table));

            // adds the table to the frame
            add(new JScrollPane(table));

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800,1000);
            setLocationRelativeTo(null);
        }

        public static void main(String[] args){             

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        new JTablePopupMenuExample().setVisible(true);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            JMenuItem menu = (JMenuItem) event.getSource();
            if (menu == menuItemAdd) {
                addNewRow();
            } else if (menu == menuItemRemove) {
                removeCurrentRow();
            } else if (menu == menuItemRemoveAll) {
                removeAllRows();
            }
        }

        private void addNewRow() {
            tableModel.addRow(new String[0]);
        }

        private void removeCurrentRow(){
            int selectedRow = table.getSelectedRow();
            tableModel.removeRow(selectedRow);



            String jdbcUrl = "jdbc:mysql://localhost/sms";
            String username = "root";
            String password = "";
            String sql = "delete from sent_messages where id = '"+msgList.get(selectedRow).getId()+"'";
           // java.sql.Statement stmt = null;

            try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password); 
                java.sql.Statement stmt = conn.createStatement();) {

              stmt.executeUpdate(sql);
              System.out.println("Record deleted successfully");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }   

        }

        private void removeAllRows() {
            int rowCount = tableModel.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                tableModel.removeRow(0);
            }
        }


        private ResultSet getTableRows() throws SQLException {
            Connection con = null;
            java.sql.Statement st = null;
            ResultSet rs = null;
            String s;
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/sms", "root", "");
                st = con.createStatement();
                s = "select * from sent_messages";
                rs = ((java.sql.Statement) st).executeQuery(s);


            }catch(Exception e) {
                    System.out.println(e.toString());
                }
             finally {
                //con.close();
            }

            return rs;
        }
    }