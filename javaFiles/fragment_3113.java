import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Tester {
   public static void main(String args[]) {
      JButton aButton = new JButton("Button");

      JPanel aPanel = new JPanel();
      JTextArea aTextArea = new JTextArea();
      JFrame aFrame = new JFrame();

      aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      aFrame.setSize(200, 200);

      aPanel.add(aTextArea);
      aPanel.add(aButton);

      aFrame.add(aPanel);
      aFrame.setVisible(true);

      aButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               aTextArea.setText("1"); 
               if(aTextArea.getText().equals("1")) {
                  System.out.println("Test Works");
               }       
      }});
   }
}