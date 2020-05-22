import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;


public class AddMemberDialog extends JDialog 
{

   private JTextField name;

   public static void main(String[] args)
   {

      AddMemberDialog input = new AddMemberDialog();
      input.setLocationRelativeTo(null);
      input.setVisible(true);

   }

   public AddMemberDialog() 
   {
      super(new JFrame("Add Member"), "Add Member");

      this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
      this.setMinimumSize(new Dimension(500, 500));
      this.name = new JTextField();

      JButton add = new JButton("Add");
      add.addActionListener(
            new ActionListener() {

               public void actionPerformed(ActionEvent arg0) {
                  close();            
               }
            });



      JButton takeInput = new JButton("takeInput");
      takeInput.addActionListener(
            new ActionListener()
            {
               public void actionPerformed(ActionEvent e)
               {


                  String txt = getName();
                  System.out.println(txt);

               }
            }
            );

      this.setLayout(new GridLayout(3, 1, 5, 5));

      this.add(name);
      this.add(add);
      this.add(takeInput);
      this.pack();
   }

   private void close()
   {   

      this.dispose(); 

   }

   public String getName()
   {    

      return this.name.getText(); 

   }

}