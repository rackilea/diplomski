import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;
import javax.swing.SwingUtilities;

public class AutoExpandSubMenusDemo extends JFrame {

    private final JPopupMenu popup = new JPopupMenu("Popup");

    public AutoExpandSubMenusDemo() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        final JMenu menuB = new JMenu("B");

        menuB.add(new JMenuItem("X"));
        final JMenuItem menuY = menuB.add(new JMenuItem("Y"));
        menuB.add(new JMenuItem("Z"));

        popup.add(new JMenuItem("A"));
        popup.add(menuB);
        popup.add(new JMenuItem("C"));

        final JButton button = new JButton("Show Popup Menu");
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popup.show(button, 0, button.getHeight());

                SwingUtilities.invokeLater(new Runnable() {

                    public void run() {
                        menuB.setPopupMenuVisible(true);
                        MenuSelectionManager.defaultManager().setSelectedPath(new MenuElement[]{popup, menuB, menuY});
                    }
                });

            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button);
        getContentPane().add(buttonPanel);
    }

    public static void main(String[] args) {
        AutoExpandSubMenusDemo f = new AutoExpandSubMenusDemo();
        f.setSize(500, 300);
        f.setVisible(true);
    }
}