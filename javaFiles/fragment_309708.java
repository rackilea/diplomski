import de.professional_webworkx.jinternalframes.jinternalframesinjtabbedpane.frame.MainFrame;
import javax.swing.SwingUtilities;

public class App {

    public static final void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MainFrame mainFrame = new MainFrame("JTabbedPane");
            }
        });
    }
}