import java.awt.Color;
import javax.swing.*;

public class JavaGui148 {

    public JComponent getGUI() {
        JPanel p = new JPanel();

        p.setBackground(Color.GREEN);

        return p;
    }

    public JMenuBar getMenuBar() {
        /**
         * Menu Bar stuff
         */
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;

        // MENU BAR 
        menuBar = new JMenuBar();
        menuBar.setVisible(true);

        // MENU 1
        menu = new JMenu("File");
        menuBar.add(menu);

        // MENU 1 ITEM
        ImageIcon icon = new ImageIcon(getClass().getResource(
                "/src/Action-exit-icon.png"));
        menuItem = new JMenuItem("Exit Program", icon);
        menu.add(menuItem);

        return menuBar;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                JavaGui148 gui = new JavaGui148();

                JFrame f = new JFrame("Demo");
                f.setJMenuBar(gui.getMenuBar());
                f.add(gui.getGUI());
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See http://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // should be done last, to avoid flickering, moving,
                // resizing artifacts.
                f.setVisible(true);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }
}