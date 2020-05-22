import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddView2 {
  private JFrame parentFrame;
  private JPanel addPanel;
  private JPanel gd;

  private JLabel nameLabel;
  private JLabel surName;
  private JLabel skype;

  private JTextField nameTField;
  private JTextField surNameTField;
  private JTextField skypeTField;

  private JButton otherButton;

  public AddView2(JFrame parent) {
    this.parentFrame = parent;
    initComponents();
  }

  private void initComponents() {
    addPanel = new JPanel(new BorderLayout());
    gd = new JPanel(new GridLayout(2, 2, 0, 5));

    nameLabel = new JLabel("Name");
    surName = new JLabel("Surname");
    skype = new JLabel("Skype");

    nameTField = new JTextField();
    surNameTField = new JTextField();
    skypeTField = new JTextField();

    otherButton = new JButton("Other");

    gd.add(nameLabel);
    gd.add(nameTField);
    gd.add(surName);
    gd.add(surNameTField);

    addPanel.add(gd, BorderLayout.CENTER);
    addPanel.add(otherButton, BorderLayout.SOUTH);

    otherButton.addActionListener(new OtherFieldsAction());
  }

  public int showAddPane() {
    return JOptionPane.showConfirmDialog(parentFrame, addPanel, "Add Contact", JOptionPane.OK_CANCEL_OPTION);
  }

  private class OtherFieldsAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      gd.setLayout(new GridLayout(3, 2, 0, 5));
      gd.add(skype);
      gd.add(skypeTField);
      // gd.revalidate(); not work
      // gd.repaint();
      // gd.validate();
      SwingUtilities.getWindowAncestor((Component) e.getSource()).pack();
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
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
    new AddView2(f).showAddPane();
  }
}