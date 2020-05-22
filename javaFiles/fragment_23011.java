import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;


public class MenuPrincipal extends javax.swing.JPanel {

    Administrador ventanaAdministrador = new Administrador();

    public MenuPrincipal()

    {
        setPreferredSize(new Dimension(290, 200));

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        ventanaAdministrador.setPreferredSize(new Dimension(350, 100));
        tabbedPane.addTab("Admin", ventanaAdministrador);
        tabbedPane.addTab("2nd Tab", new JPanel());
        add(tabbedPane);
    }


    /**
     * @param args
     */
    public static void main(String[] args) {

        JFrame testFrame = new JFrame("Main Test Window");
        testFrame.setDefaultCloseOperation(WindowConstants.
                     DISPOSE_ON_CLOSE);
        testFrame.setPreferredSize(new Dimension(450, 350));
        MenuPrincipal menuP = new MenuPrincipal();
        testFrame.getContentPane().add(menuP);

        testFrame.pack();
        testFrame.setVisible(true);

    }
}