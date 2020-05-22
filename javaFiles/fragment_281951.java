import java.awt.*;
 import javax.swing.*;

  public class NewClass {

 static JFrame aWindow = new JFrame("This is BOX LAYOUT"); 
 public static void main(String[] args) {

  JPanel panel1 = new JPanel(); 
  panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
  panel1.setBackground(Color.yellow);

  JPanel panel2 = new JPanel(); 
  panel2.setLayout(new FlowLayout());
  panel2.setBackground(Color.ORANGE);

 for(int i = 0; i <5; i++)
   panel1.add(new JCheckBox("CheckBox " + (i+1)));     

    aWindow.add(panel1,BorderLayout.WEST);
    aWindow.add(panel2, BorderLayout.CENTER);
    aWindow.setVisible(true);                    
    aWindow.setSize(300,300); 
    aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }
}