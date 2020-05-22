public class GUI extends JFrame {
     JButton deleteButton; 
     public GUI (View v, Controller c) {
         deleteButton.addActionListener(c.getDeleteListener()); 
     }
 }