import java.awt.event.*;

public class null_login_type extends JFrame{    
  private JLabel admin_password_label,heading,login_label,password_label,id_label;
  private JButton user_login_button,admin_login_button,enquiry_button,logins1,signup;
  private JTextField user_field,password_field,admin_field,admin_password_field;
  private ButtonGroup bg;
  private JPanel panel;
  null_login_type()
  {
    panel = new JPanel();
    this.setContentPane(panel);
    this.setLayout(null);
    user_login_button = new JButton("Login as User");
    logins1 = new JButton("Login");
    user_field = new JTextField("User_field");
    id_label = new JLabel("Id_label");        
    user_login_button.setBounds(0,100, 150, 30);
    logins1.setBounds(250,200,100,30);
    user_field.setBounds(200,60,150,30);         
    panel.add(user_login_button);       
    event e = new event();
    user_login_button.addActionListener(e);
  }
  public class event implements ActionListener
  {
    public void actionPerformed(ActionEvent e){          
      logins1.setBounds(250,60,150,30);; 
      // user_field.setBounds(250,60,150,30);;
      // add(user_field);
      panel.add(logins1);
      panel.repaint();
      panel.revalidate();
    }   
  }

  public static void main(String args[])
  {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          null_login_type gui = new null_login_type();          
          gui.setSize(420,300);
          gui.setLocation(530,200);
          gui.setVisible(true);
          gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
        }
      });
  }
}