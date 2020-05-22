import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public class TestPopupMenu {

    private void initUI() {
        final JFrame frame = new JFrame(TestPopupMenu.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        final JPopupMenu popup = new JPopupMenu();
        final List<JMenuItem> items = new ArrayList<JMenuItem>();
        for (int i = 0; i < 5; i++) {
            JMenuItem item = new JMenuItem(new AbstractAction("Action " + (i + 1)) {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(popup, getValue(NAME) + " has been clicked");
                }
            });
            item.setEnabled(i % 2 == 0);
            items.add(item);
            popup.add(item);
        }
        popup.addPopupMenuListener(new PopupMenuListener() {

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                for (JMenuItem item : items) {
                    item.setEnabled(!item.isEnabled());
                }
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {

            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {

            }
        });
        panel.setComponentPopupMenu(popup);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
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
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestPopupMenu().initUI();
            }
        });
    }
}