import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;


public class TestFrame extends JFrame {

    public TestFrame() {
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        DrawPanel p = new DrawPanel();
        add(p);

        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("menu");
        JPopupMenu popupMenu = menu.getPopupMenu();
        popupMenu.addPopupMenuListener(new PopupMenuListener() {

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {

            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
                repaint();
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent arg0) {

            }
        });
        bar.add(menu);
        menu.add(new JMenuItem("item"));
        setJMenuBar(bar);
    }


    public static void main(String args[]) {
        new TestFrame();
    }


    private class DrawPanel extends JPanel{

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100,100);
        }

        @Override
        protected void paintComponent(Graphics arg0) {
            super.paintComponent(arg0);

            Random r = new Random();
            int nextInt = r.nextInt(20);
            arg0.drawOval(nextInt, nextInt, 20, 20);
        }
    }
}