package swingDemo;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

;

public class ScrollDemo1 extends JFrame {

  public ScrollDemo1() {
    JLabel label = new JLabel();
    label.setBounds(50, 0, 1000, 100);
    label.setText("Do you want to have a coffee together?");

    JButton button = new JButton("Of course!");
    button.setBounds(10, 60, 150, 50);
    button.addActionListener(e -> label.setText("Well, let's go!"));
    JButton button2 = new JButton("No,sorry.");
    button2.setBounds(170, 60, 150, 50);
    button2.addActionListener(e -> label.setText("Well, let's go!"));

    JPanel panel = new JPanel();
    panel.setBounds(10, 10, 10, 10);
    panel.add(button2);
    panel.add(button);
    panel.add(label);
    // This causes problems:
//    panel.setLayout(null);

    JScrollPane scrollPane = new JScrollPane(panel);
    scrollPane.setViewportBorder(BorderFactory.createLineBorder(Color.red));
    scrollPane.setPreferredSize(new Dimension(20, 20));
    add(scrollPane);
    // This is redundent:
//    scrollPane.setViewportView(panel);
    setBounds(10, 10, 40, 60);
    setTitle("Dating Robot");
    // Some initial size (or "pack") is needed to make it big enough to see
    setSize(500, 500);
    // This makes the app exit cleanly when closing the frame
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    SwingUtilities.invokeLater(() -> {
      ScrollDemo1 obj = new ScrollDemo1();
      obj.setVisible(true);
    });
  }
}