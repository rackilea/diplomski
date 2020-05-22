import java.awt.ComponentOrientation;
import javax.swing.*;

public class MenuGlueDemo {

    public MenuGlueDemo() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createMenu("Menu 1"));
        menuBar.add(createMenu("Menu 2"));
        menuBar.add(createMenu("Menu 3"));
        menuBar.add(new JSeparator());
        menuBar.add(new JButton("   Seach ....  "));
        menuBar.add(new JTextField("   Seach ....  "));
        menuBar.add(new JComboBox(new Object[]{"height", "length", "volume"}));
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(createMenu("About"));
        JFrame frame = new JFrame("MenuGlueDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(menuBar);
        frame.pack();
        frame.setVisible(true);
    }

    public JMenu createMenu(String title) {
        JMenu m = new JMenu(title);
        m.add("Menu item #1 in " + title);
        m.add("Menu item #2 in " + title);
        m.add("Menu item #3 in " + title);
        if (title.equals("About")) {
            m.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        return m;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MenuGlueDemo menuGlueDemo = new MenuGlueDemo();
            }
        });
    }
}