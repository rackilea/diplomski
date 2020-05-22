import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextClient extends JFrame {
   public JPanel mypanel = new JPanel();
   public JButton send = new JButton("Send");
   public JButton changename = new JButton("Change name");
   public JTextField textf = new JTextField(10);
   public JTextField textname = new JTextField(10);
   public JLabel username = new JLabel("Name:");
   public String user;

   public TextClient() throws IOException {
      add(mypanel);
      mypanel.add(textf);
      mypanel.add(send);
      mypanel.add(username);
      mypanel.add(textname);
      mypanel.add(changename);

      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      pack();
      setVisible(true);
      setLocationRelativeTo(null);

      changename.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent ev) {
            user = textname.getText();
            System.out.println("user in action listener: " + user);
         }
      });

      // you're trying to use user here!
      System.out.println("user outside of action " 
             + "listener where you try to use it: " + user); // !!

      send.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ev) {
            String sendit = textf.getText();
            System.out.println("sendit: " + sendit);
         }
      });

   }

   public static void main(String[] args) {
      try {
         new TextClient();
      } catch (IOException ex) {
         Logger.getLogger(TextClient.class.getName()).log(Level.SEVERE, null,
               ex);
      }
   }
}