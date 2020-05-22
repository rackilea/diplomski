import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class MenuExample extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextPane pane;
    private JMenuBar menuBar;

    public MenuExample() {
        menuBar = new JMenuBar();
        JMenu formatMenu = new JMenu("Justify");
        formatMenu.setMnemonic('J');
        formatMenu.setIcon(UIManager.getIcon("OptionPane.errorIcon"));
        MenuAction leftJustifyAction = new MenuAction("Left", UIManager.getIcon("OptionPane.errorIcon"));
        MenuAction rightJustifyAction = new MenuAction("Right", UIManager.getIcon("OptionPane.informationIcon"));
        MenuAction centerJustifyAction = new MenuAction("Center", UIManager.getIcon("OptionPane.warningIcon"));
        MenuAction fullJustifyAction = new MenuAction("Full", UIManager.getIcon("OptionPane.questionIcon"));
        JMenuItem item;
        item = formatMenu.add(leftJustifyAction);
        item.setMnemonic('L');
        item = formatMenu.add(rightJustifyAction);
        item.setMnemonic('R');
        item = formatMenu.add(centerJustifyAction);
        item.setMnemonic('C');
        item = formatMenu.add(fullJustifyAction);
        item.setMnemonic('F');
        menuBar.add(formatMenu);
        menuBar.add(createMenu("Menu 1"));
        menuBar.add(createMenu("Menu 2"));
        menuBar.add(createMenu("Menu 3"));
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(new JSeparator());
        menuBar.add(new JButton("   Seach ....  "));
        menuBar.add(new JLabel());
        menuBar.add(new JTextField("   Seach ....  "));
        menuBar.add(new JComboBox(new Object[]{"height", "length", "volume"}));
        menuBar.add(createMenu("About"));
        menuBar.setBorder(new BevelBorder(BevelBorder.RAISED));

    }

    private JMenu createMenu(String title) {
        JMenu m = new JMenu(title);
        m.add("Menu item #1 in " + title);
        m.add("Menu item #2 in " + title);
        m.add("Menu item #3 in " + title);
        if (title.equals("About")) {
            m.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        return m;
    }

    class MenuAction extends AbstractAction {

        public MenuAction(String text, Icon icon) {
            super(text, icon);
        }

        public void actionPerformed(ActionEvent e) {
            try {
                pane.getStyledDocument().insertString(0,
                        "Action [" + e.getActionCommand() + "] performed!\n",
                        null);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String s[]) {
        MenuExample example = new MenuExample();
        example.pane = new JTextPane();
        example.pane.setPreferredSize(new Dimension(250, 250));
        example.pane.setBorder(new BevelBorder(BevelBorder.LOWERED));
        JFrame frame = new JFrame("Menu Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(example.menuBar);
        frame.getContentPane().add(example.pane, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}