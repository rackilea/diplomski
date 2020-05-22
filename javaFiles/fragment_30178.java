import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class JTabbedPaneDemo3 implements Runnable
{
  JTextField txtFoo;
  JTextField txtBar;
  JTabbedPane tabbedPane;

  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new JTabbedPaneDemo3());
  }

  public void run()
  {
    txtFoo = new JTextField(10);
    final JPanel pnlFoo = new JPanel();
    pnlFoo.add(new JButton("Button 1"));
    pnlFoo.add(new JLabel("Foo"));
    pnlFoo.add(txtFoo);

    txtBar = new JTextField(10);
    final JPanel pnlBar = new JPanel();
    pnlBar.add(new JButton("Button 3"));
    pnlBar.add(new JLabel("Bar"));
    pnlBar.add(txtBar);

    tabbedPane = new JTabbedPane();
    tabbedPane.addTab("Tab 1", pnlFoo);
    tabbedPane.addTab("Tab 2", pnlBar);

    tabbedPane.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent e)
      {
        Component comp = tabbedPane.getSelectedComponent();
        if (comp.equals(pnlFoo))
        {
          txtFoo.requestFocusInWindow();
        }
        else if (comp.equals(pnlBar))
        {
          txtBar.requestFocusInWindow();
        }
      }
    });

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(460, 200);
    frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    txtFoo.requestFocusInWindow();
  }
}