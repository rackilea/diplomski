import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.SwingUtilities;

/**
 * @see https://stackoverflow.com/a/54958587/230513
 */
public class JFrameTest extends JFrame {

    public JFrameTest(String title) {
        super(Objects.requireNonNull(title));
    }

    private static class OpenDialogAction extends AbstractAction {

        private final JFrame parent;
        private final URI uri;
        private JDialog dialog;

        public OpenDialogAction(JFrame parent, URI uri) {
            super.putValue(NAME, "Open " + uri.getAuthority());
            this.parent = Objects.requireNonNull(parent);
            this.uri = Objects.requireNonNull(uri);
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            if (dialog != null) {
                dialog.toFront();
                return;
            }
            dialog = new JDialog(parent, Dialog.ModalityType.MODELESS);
            dialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    dialog = null;
                }
            });
            dialog.setTitle(uri.getAuthority());
            JFXPanel fxPanel = new JFXPanel() {

                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(640, 480);
                }
            };
            dialog.add(fxPanel);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            Platform.runLater(() -> {
                WebView webView = new WebView();
                webView.getEngine().load(uri.toString());
                Scene scene = new Scene(webView);
                fxPanel.setScene(scene);
            });
        }
    }

    public static void main(String[] args) throws URISyntaxException {
        URI uri1 = new URI("https://www.example.com");
        URI uri2 = new URI("https://www.example.net");
        URI uri3 = new URI("https://www.example.org");
        SwingUtilities.invokeLater(() -> {
            JFrameTest test = new JFrameTest("Test");
            test.setLayout(new GridLayout(0, 1));
            test.add(new JButton(new OpenDialogAction(test, uri1)));
            test.add(new JButton(new OpenDialogAction(test, uri2)));
            test.add(new JButton(new OpenDialogAction(test, uri3)));
            test.pack();
            test.setDefaultCloseOperation(EXIT_ON_CLOSE);
            test.setLocationByPlatform(true);
            test.setVisible(true);
        });
    }
}