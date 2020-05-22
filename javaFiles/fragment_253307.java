import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class TestTable {

    public static void main(String[] args) {
        new TestTable();
    }

    public TestTable() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new Bill());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Bill extends JPanel implements ActionListener {

        JTextField textFieldId;
        JLabel l1;
        JLabel l2;
        JButton b2;
        ResultSet rs1 = null;
        DefaultTableModel dtm = new DefaultTableModel();

        public Bill() {
            setLayout(new BorderLayout());

            JPanel fields = new JPanel();

            textFieldId = new JTextField(10);
            l1 = new JLabel("New Customer Entry :-");
            l2 = new JLabel("Customer Id");
            b2 = new JButton("Ok");

            fields.add(l2);
            fields.add(textFieldId);
            fields.add(b2);

            add(fields, BorderLayout.NORTH);

            b2.addActionListener(this);

            // Don't forget to add a table.
            add(new JScrollPane(new JTable(dtm)));

        }

        public void actionPerformed(ActionEvent e) {

            System.out.println("You clicked the button");
            if (e.getSource() == b2) {
                PreparedStatement ps = null;
                try {
                    Connection con;
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    con = DriverManager.getConnection("jdbc:odbc:devendra");
                    ps = con.prepareStatement("SELECT FROM Customer where Customer_Id = ?");
                    // You must bind the parameter with a value...
                    ps.setString(1, textFieldId.getText());
                    rs1 = ps.executeQuery();
                    while (rs1.next()) {
                        dtm.addRow(new Object[]{
                            rs1.getString(1), rs1.getString(2), rs1.getInt(3), rs1.getString(4)});
                    }
                    JOptionPane.showMessageDialog(null, "You successfully Enter the Entry");
                } catch (SQLException s) {
                    System.out.println("SQL code does not execute.");
                    s.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Please Enter the Detail Correctly");
                } catch (Exception exp) {
                    exp.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Failed to perform query: " + exp.getMessage());
                } finally {

                    try {
                        ps.close();
                    } catch (Exception ex) {
                    }

                }
            }
        }
    }
}