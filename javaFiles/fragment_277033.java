import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class DefaultButton {

  public static void main(String[] args) {

    JButton button1 = new JButton("Button 1");
    button1.addActionListener(e -> System.out.println("Button 1 action fired"));

    JButton button2 = new JButton("Button 2");
    button2.addActionListener(e -> System.out.println("Button 2 action fired"));

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new FlowLayout());
    frame.getContentPane().add(button1);
    frame.getContentPane().add(button2);

    frame.getRootPane().setDefaultButton(button2);

    frame.setBounds(300, 200, 400, 300);
    frame.setVisible(true);
  }
}