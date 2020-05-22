import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class Main extends JFrame {
    private static final long serialVersionUID = 3206847208968227199L;
    JButton but;
    MenuBar mB;

    private Main() {
        setSize(600, 600);

        mB = new MenuBar();
        setJMenuBar(mB);

        but = new JButton("Change Font");
        but.addActionListener(new CustomActionListener());
        add(but);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Main();
    }

    private class MenuBar extends JMenuBar {
        private static final long serialVersionUID = -2055260049565317972L;
        Font menuFont = new FontUIResource("Courier", Font.ITALIC + Font.BOLD, 12);
        Font menuItemFont = new FontUIResource("sans-serif", 0, 12);
        JMenu menu, subMenu;

        MenuBar() {
            UIManager.put("Menu.font", menuFont);
            UIManager.put("MenuItem.font", menuItemFont);

            menu = new JMenu("Menu");

            subMenu = new JMenu("Sub Menu");
            subMenu.add(new JMenuItem("Sub Item"));
            subMenu.add(new JMenu("Sub Menu"));
            menu.add(subMenu);

            menu.add(new JMenuItem("Sub Item"));
            menu.add(new JMenu("Sub Menu"));

            add(menu);

            menu = new JMenu("Another Menu");
            menu.add(new JMenu("Sub Menu"));
            menu.add(new JMenuItem("Sub Item"));
            menu.add(new JMenu("Sub Menu"));
            add(menu);
        }

        public void setMyFont(Font f, Font f2) {

            menuFont = f;
            menuItemFont = f2;
            UIManager.put("Menu.font", menuFont);
            UIManager.put("MenuItem.font", menuItemFont);
            SwingUtilities.updateComponentTreeUI(Main.this);
        }
    }

    private class CustomActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mB.setMyFont(new FontUIResource("sans-serif", 0, 12), new FontUIResource("Courier", Font.ITALIC + Font.BOLD, 12));
        }
    }
}