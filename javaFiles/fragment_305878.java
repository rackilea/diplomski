import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MenuTester {

    public static void main(String[] args) {
        new MenuTester();
    }

    public MenuTester() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                final JFrame frame = new JFrame();
                frame.setBounds(100, 100, 300, 200);

                final JButton button = new JButton("Show Menu");
                button.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        final JPopupMenu popupMenu = new JPopupMenu();
                        popupMenu.add(new JMenuItem("aaaa"));
                        popupMenu.add(new JMenuItem("bbbb"));
                        popupMenu.add(new JMenuItem("cccc"));
                        popupMenu.setLocation(100, 100);
                        popupMenu.setVisible(true);
//                        try {
//                            Thread.sleep(2000); // Leave enough time to clearly see the ?invalidated/background? area.
//                        } catch (InterruptedException ex) {
//                            // Nothing to do
//                        }
//                        SwingUtilities.invokeLater(new Runnable() {
//                            @Override
//                            public void run() {
//                                // Hide after 1 second
//                                try {
//                                    Thread.sleep(1000);
//                                } catch (InterruptedException ex) {
//                                    // Nothing to do
//                                }
//                                popupMenu.setVisible(false);
//                            }
//                        });
                    }
                });
                frame.add(button);
                frame.setVisible(true);
            }
        });
    }
}