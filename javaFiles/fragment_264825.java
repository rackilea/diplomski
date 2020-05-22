import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTreeSelection extends JFrame {
  public JTreeSelection() {
    super("Test");
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {}
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    add(new JButton("Example"), BorderLayout.PAGE_START);
    add(new JScrollPane(new JTree()), BorderLayout.CENTER);
    //pack();
    //setSize(320, 240);
  }
  public static void main(String[] args) {
    //You may also need to understand the EDT
    //EventQueue.invokeLater(new Runnable() {
    //  @Override public void run() {
    //      new JTreeSelection().setVisible(true);
    //  }
    //});
    new JTreeSelection().setVisible(true);
  }
}