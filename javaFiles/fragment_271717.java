import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class Formatka extends JPanel {

    private JMenuItem klienciMenuItem = new JMenuItem("Klienci");
    private JPopupMenu menuPopup = new JPopupMenu();

    public Formatka() {
        this.add(new JLabel("Right-click for popup menu."));
        menuPopup.add(klienciMenuItem);
        this.setComponentPopupMenu(menuPopup);
    }

    private void display() {
        JFrame f = new JFrame("Formatka");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Formatka().display();
            }
        });
    }
}