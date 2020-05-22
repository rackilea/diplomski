import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel2 extends JPanel {
  private JPanel innerPanel;

  public Panel2() {
    super(new BorderLayout());
    innerPanel = new InnerPanel();
    //this.setLayout(null);
    //innerPanel.setBounds(30, 30, 100, 200);
    this.add(innerPanel);
    this.setOpaque(false);
  }
  private /* TEST static */ class InnerPanel extends JPanel {
    private SpringLayout layout;
    private JButton someButton;

    public InnerPanel() {
      super();
      layout = new SpringLayout();
      this.setLayout(layout);

      someButton = new JButton("X");
      //someButton.setPreferredSize(new Dimension(45, 25));
      System.out.println(innerPanel); //TEST
      //layout.putConstraint(SpringLayout.NORTH, someButton, +5, SpringLayout.NORTH, innerPanel);
      //layout.putConstraint(SpringLayout.EAST, someButton, -5, SpringLayout.EAST, innerPanel);
      layout.putConstraint(SpringLayout.NORTH, someButton, +5, SpringLayout.NORTH, this);
      layout.putConstraint(SpringLayout.EAST, someButton, -5, SpringLayout.EAST, this);

      this.add(someButton);
      this.setOpaque(false);
    }
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.add(new Panel2());
    f.setSize(800, 600);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}