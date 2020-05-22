import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Searchdb extends JFrame implements ActionListener {

//Initializing Components
    JLabel lb,lbd,lb1, lb2, lb3, lb5;
    JTextField tf1, tf2,tf3,tf5,tfd;
    JButton btn;

    //Creating Constructor for initializing JFrame components
    Searchdb() {
        //Providing Title
        super("Fetching Roll Information");
        lb5 = new JLabel("Roll Number:");
        lb5.setBounds(20, 20, 100, 20);
        tf5 = new JTextField(20);
        tf5.setBounds(130, 20, 200, 20);

        lbd = new JLabel("Date:");
        lbd.setBounds(20, 50, 100, 20);
        tfd = new JTextField(20);
        tfd.setBounds(130, 50, 200, 20);


        btn = new JButton("Submit");
        btn.setBounds(50, 50, 100, 20);
        btn.addActionListener(this);

        lb = new JLabel("Fetching Student Information From Database");
        lb.setBounds(30, 80, 450, 30);
        lb.setForeground(Color.black);
        lb.setFont(new Font("Serif", Font.PLAIN, 12));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        lb1 = new JLabel("Name:");
        lb1.setBounds(20, 120, 100, 20);
        tf1 = new JTextField(50);
        tf1.setBounds(130, 120, 200, 20);
        lb2 = new JLabel("Fathername:");
        lb2.setBounds(20, 150, 100, 20);
        tf2 = new JTextField(100);
        tf2.setBounds(130, 150, 200, 20);
        lb3 = new JLabel("State:");
        lb3.setBounds(20, 180, 100, 20);
        tf3 = new JTextField(50);
        tf3.setBounds(130, 180, 200, 20);

        setLayout(null);

        //Add components to the JFrame
        add(lb5);
        add(tf5);
        add(lbd);
        add(tfd);
        add(btn);

        add(lb);
        add(lb1);
        add(tf1);
        add(lb2);
        add(tf2);
        add(lb3);
        add(tf3);


        //Set TextField Editable False
        tf1.setEditable(false);
        tf2.setEditable(false);
        tf3.setEditable(false);

    }

    public void actionPerformed(ActionEvent e) {
        //Create DataBase Coonection and Fetching Records

        try {
            String str = tf5.getText();

            String stri = tfd.getText();

            System.out.println(str);
            System.out.println(stri);

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//host:port/servicename","username","password");

            String str1 ="select Name,Fathername,State from student_db where roll_number='"+str+"' and medium='"+stri+"'";

            PreparedStatement st = con.prepareStatement(str1);
            System.out.println(st);
            st.setString(1, str);
            st.setString(2, stri);



            //Excuting Query
            ResultSet rs = st.executeQuery();
            System.out.println(rs);

            if (rs.next()) {
                String s = rs.getString(1);
                String s1 = rs.getString(2);
                String s2 = rs.getString(3);


                //Sets Records in TextFields.
                tf1.setText(s);
                tf2.setText(s1);
                tf3.setText(s2);

            } else {
                JOptionPane.showMessageDialog(null, "Student not Found");
            }

            //Create Exception Handler
        } catch (Exception ex) {

            System.out.println(ex);
        }
    }
//Running Constructor

    public static void main(String args[]) {
        new Searchdb();
    }
}