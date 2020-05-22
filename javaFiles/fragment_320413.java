import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class UIManagerFontChangeExample {

    private JFrame frame;
    private JLabel label;
    private JMenuItem item1, item2;
    private JMenu menu;
    private JMenuBar bar;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Font f = new Font("sans-serif", Font.PLAIN, 12);
                UIManager.put("Menu.font", f);
                UIManager.put("MenuItem.font", f);
                UIManagerFontChangeExample example = new UIManagerFontChangeExample();
                example.createAndShowGui();
            }
        });
    }

    public void createAndShowGui() {
        frame = new JFrame("Font changing example");
        label = new JLabel("This is a label");
        bar = new JMenuBar();
        menu = new JMenu("Menu");
        item1 = new JMenuItem("Item1");
        item2 = new JMenuItem("Item2");

        menu.add(item1);
        menu.add(item2);
        bar.add(menu);

        frame.add(label);
        frame.setJMenuBar(bar);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}