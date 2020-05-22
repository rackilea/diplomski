import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RolloverMenuItem {
    ImageIcon stackIcon = new ImageIcon(getClass().getResource("/resources/stackoverflow2.png"));

    public RolloverMenuItem() {
        ImageIcon newIcon = new ImageIcon(getClass().getResource("/resources/image/new.gif"));
        ImageIcon saveIcon = new ImageIcon(getClass().getResource("/resources/image/open.gif"));
        ImageIcon openIcon = new ImageIcon(getClass().getResource("/resources/image/save.gif"));

        JMenu menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        JMenuItem item1 = createMenuItem(newIcon, "New");
        JMenuItem item2 = createMenuItem(openIcon, "Open");
        JMenuItem item3 = createMenuItem(saveIcon, "Save");
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);

        JFrame frame = new JFrame("Rollover MenuItem");
        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private JMenuItem createMenuItem(final ImageIcon icon, String title) {
        JMenuItem item = new JMenuItem(title);
        item.setIcon(icon);

        ChangeListener cl = new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem item = (JMenuItem) e.getSource();
                    if (item.isSelected() || item.isArmed()) {
                        item.setIcon(stackIcon);
                    } else {
                        item.setIcon(icon);
                    }
                }
            }
        };
        item.addChangeListener(cl);

        return item;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RolloverMenuItem();
            }
        });
    }
}