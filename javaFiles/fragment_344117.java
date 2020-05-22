import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

public class TabbedPaneAccessibleTest {
  public JComponent makeUI() {
    final JTabbedPane tabbedPane = new JTabbedPane();
    tabbedPane.getAccessibleContext().addPropertyChangeListener(
        new PropertyChangeListener() {
      @Override public void propertyChange(PropertyChangeEvent evt) {
        String property = evt.getPropertyName();
        System.out.println("property -> " + property);
        if (evt.getOldValue() instanceof Icon
            && evt.getNewValue() instanceof Icon) {
          System.out.println("New Icon: " + evt.getNewValue());
        }
      }
    });
    Icon someIcon = UIManager.getIcon("OptionPane.errorIcon");
    Component c = Box.createRigidArea(new Dimension(320, 240));
    tabbedPane.insertTab("title", someIcon, c, null, 0);

    JButton changeIconBtn = new JButton(new AbstractAction("Change Icon") {
      @Override public void actionPerformed(final ActionEvent e) {
        Icon newIcon = UIManager.getIcon("OptionPane.warningIcon");
        tabbedPane.setIconAt(0, newIcon);
      }
    });

    JPanel p = new JPanel(new BorderLayout());
    p.add(new JScrollPane(tabbedPane));
    p.add(changeIconBtn, BorderLayout.SOUTH);
    return p;
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
    f.getContentPane().add(new TabbedPaneAccessibleTest().makeUI());
    f.pack();
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}