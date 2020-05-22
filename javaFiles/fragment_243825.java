import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Menu3 extends JFrame
{
  public Menu3()
  {
    super("Menu3");
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    JMenu mItems = new JMenu("Items");
    menuBar.add(mItems);
    mItems.add(JM.create("A"));
    mItems.add(JM.create("B"));
    mItems.add(JM.create("C"));
    JLabel stuff = new JLabel("Other stuff");
    stuff.setPreferredSize(new Dimension(200,200));
    getContentPane().add(stuff);
    pack();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
  }

  private static class JM extends JMenu
    implements MouseListener
  {
    private static final String ARROW_ICON_KEY = "Menu.arrowIcon";

    private boolean populated = false; // Submenu already populated?

    protected JM(String label)
    {
      super(label);
      addMouseListener(this);
    }

    // This static factory method returns a JM without an arrow icon.

    public static JM create(String label)
    {
      UIDefaults uiDefaults = UIManager.getLookAndFeelDefaults();
      Object savedArrowIcon = uiDefaults.get(ARROW_ICON_KEY);
      uiDefaults.put(ARROW_ICON_KEY,null);
      JM newJM = new JM(label);
      uiDefaults.put(ARROW_ICON_KEY,savedArrowIcon);
      return newJM;
    }

    // MouseListener

    public void mouseClicked(MouseEvent ev)
    {
      // Since some menu elements need to execute actions and a JMenu
      // doesn't normally respond to mouse clicks, we execute click
      // actions here.  In real life we'll probably fire some event
      // for which an EventListener can listen.  For illustrative
      // purposes we'll just write out a trace message.

      System.err.println("Executing "+getText());
      MenuSelectionManager.defaultManager().clearSelectedPath();
    }
    public void mouseEntered(MouseEvent ev)
    {
      // In real life we'd want a Timer to delay showing the submenu
      // until we are sure the user is "hovering" the mouse.
      // For simplicity I've omitted it.

      // Populate this submenu only once
      if (!populated) {
        // For purposes of example, show a submenu for item "B" only.
        if (getText().equals("B")) {
          // Expensive processing...
          add(create("D"));
          add(create("E"));
        }
        populated = true;
      }
    }
    public void mouseExited(MouseEvent ev) {}
    public void mousePressed(MouseEvent ev) {}
    public void mouseReleased(MouseEvent ev) {}
  }

  public static void main(String[] args)
    throws Exception
  {
    new Menu3().setVisible(true);
  }
}