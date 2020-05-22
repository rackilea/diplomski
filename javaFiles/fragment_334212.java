import java.awt.*;
 import javax.swing.*;

 public class GUI extends JFrame{
      // Now display is private to the GUI class
      private JTextArea display;
      public GUI(){
         FlowLayout flo = new FlowLayout();
         Container pane = getContentPane();

         display =  = new JTextArea (30, 90);
         JButton button = new JButton("CLICK ME");
         JLabel label = new JLabel("Dont Click Him!");

         setTitle("Merchables!?");
         setVisible(true);
         setSize(1000,600);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         pane.setLayout(flo);
         pane.add(display);
         pane.add(button);
         pane.add(label);
   }

   // Get accessor method for display variable
   public JTextArea getDisplay() {
         return display;
   }
}