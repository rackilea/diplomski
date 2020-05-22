import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Test extends JFrame {

  private JPanel panel = new JPanel();

/**
 * Launch the application.
 */
   public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
  public void run() {
    try {
          Test frame = new Test();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public Test() {
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    JButton btnTest = new JButton("press");

    btnTest.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        testFunction();
      }
    });

    btnTest.setBounds(162, 188, 89, 23);
    panel.add(btnTest);
    this.setSize(new Dimension(300, 300));
    this.add(panel);
  }

  public void testFunction()
  { 
    JTextPane textPane = new JTextPane();
    textPane.setBounds(162, 231, 89, 20);
    textPane.setText(":)");
    panel.add(textPane);
  }
}