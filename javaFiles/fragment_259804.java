import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;

public class RadioMenus {

    private static final String MENU_ORDRE_TITLE = "Tilte";
    private static final String MENU_ORDRE_NSEQC = "NSEQC";
    private static final String MENU_ORDRE_NSEQD = "NSEQD";
    private static final String MENU_ORDRE_FORMEC = "FORMEC";

    public RadioMenus() {
        JMenuBar menubar = new JMenuBar();
        menubar.add(getOrdreMenu());

        JFrame frame = new JFrame("Menu");
        frame.setJMenuBar(menubar);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new RadioMenus();
            }
        });
    }

    private JMenu getOrdreMenu() {
        MyMenuListener listener = new MyMenuListener();

        JMenu menu = new JMenu(MENU_ORDRE_TITLE);
        ButtonGroup group = new ButtonGroup();

        JRadioButtonMenuItem item = new JRadioButtonMenuItem(MENU_ORDRE_NSEQC);
        item.addActionListener(listener);
        group.add(item);
        menu.add(item);

        JRadioButtonMenuItem item1 = new JRadioButtonMenuItem(MENU_ORDRE_NSEQD);
        item1.addActionListener(listener);
        group.add(item1);
        menu.add(item1);

        JRadioButtonMenuItem item2 = new JRadioButtonMenuItem(MENU_ORDRE_FORMEC);
        item2.addActionListener(listener);
        group.add(item2);
        menu.add(item2);

        return menu;
    }

    public class MyMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JRadioButtonMenuItem menuItem = (JRadioButtonMenuItem)e.getSource();
            System.out.println(menuItem.getActionCommand());
        }
    }
}