import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestMenu {

    protected void initUI() {
        JFrame frame = new JFrame(TestMenu.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar bar = new JMenuBar();
        JMenu topMenu = new JMenu("Top Menu");
        JMenu subMenu = new JMenu("Sub menu") {
            private KeyStroke accelerator;

            @Override
            public KeyStroke getAccelerator() {
                return accelerator;
            }

            @Override
            public void setAccelerator(KeyStroke keyStroke) {
                KeyStroke oldAccelerator = accelerator;
                this.accelerator = keyStroke;
                repaint();
                revalidate();
                firePropertyChange("accelerator", oldAccelerator, accelerator);
            }
        };
        subMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.CTRL_MASK));
        JMenuItem item1 = new JMenuItem("Item 1");
        JMenuItem item2 = new JMenuItem("Item 2");
        subMenu.add(item1);
        subMenu.addSeparator();
        subMenu.add(item2);
        topMenu.add(subMenu);
        bar.add(topMenu);
        frame.setJMenuBar(bar);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (UnsupportedLookAndFeelException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                new TestMenu().initUI();
            }
        });
    }

}