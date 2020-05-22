import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Masud
 */
public class Test extends JFrame {

    public Test() throws HeadlessException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoodb", "root", "12345678");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from ABC");
            JTable jTable = new JTable(DbUtils.resultSetToTableModel(resultSet));
            JScrollPane pane = new JScrollPane(jTable);
            add(pane);
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        pack();
        setVisible(true);
    }

    public static void main(String[] args){
        new Test();
    }
}