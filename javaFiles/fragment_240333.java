import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ResultSetDemo {

    public ResultSetDemo() {
        JFrame f = new JFrame();
        f.setLayout(new FlowLayout());
        JComboBox cb1 = new JComboBox();
        f.add(cb1);
        JComboBox cb2 = new JComboBox();
        f.add(cb2);
        JComboBox cb3 = new JComboBox();
        f.add(cb3);
        JComboBox cb4 = new JComboBox();
        f.add(cb4);
        JComboBox cb5 = new JComboBox();
        f.add(cb5);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name", my_sql_username, mysql_password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select DISTINCT tname from try");
            while (rs.next()) {
                cb1.addItem(rs.getString("tname"));
                cb2.addItem(rs.getString("tname"));
                cb3.addItem(rs.getString("tname"));
                cb4.addItem(rs.getString("tname"));
                cb5.addItem(rs.getString("tname"));  

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        f.setSize(600, 100);
        f.setVisible(true);

    }

    public static void main(String[] args) {
        new ResultSetDemo();
    }
}