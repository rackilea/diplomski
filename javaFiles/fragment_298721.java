import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;

public class MainClass {

    public static void main(String[] args) {
        JFrame frame = new JFrame ();
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        final JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setLayout(new MigLayout("center panel",
                "[100px:100px:1366px,grow,shrink 50,center]",
                "[100px:100px:768px,grow,shrink 50,center]"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        JInternalFrame form = new JInternalFrame();
        form.setResizable(true);      
        form.setVisible(true);
        desktopPane.add(form);
        frame.add(desktopPane);
    }
}