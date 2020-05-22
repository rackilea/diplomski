import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LinkButtonExample {

    public static void main(String[] args) {
        new LinkButtonExample();
    }

    public LinkButtonExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    }

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLayout(new GridBagLayout());
                    frame.add(new JButton(new OpenURLAction(new URL("http://stackoverflow.com/"))));
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public class OpenURLAction extends AbstractAction {

        private URL url;

        public OpenURLAction(URL url) {

            this("<HTML>Click the <FONT color=\\\"#000099\\\"><U>link</U></FONT> to go to the website.</HTML>", url);

        }

        public OpenURLAction(String text, URL url) {

            putValue(NAME, text);
            setURL(url);

        }

        public void setURL(URL url) {
            this.url = url;
            setEnabled(
                            url != null
                            && Desktop.isDesktopSupported()
                            && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE));
            putValue(SHORT_DESCRIPTION, url == null ? null : url.toString());
        }

        public URL getURL() {
            return url;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (isEnabled()) {

                URL url = getURL();
                if (url != null && Desktop.isDesktopSupported()
                                && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    try {
                        Desktop.getDesktop().browse(url.toURI());
                    } catch (    IOException | URISyntaxException ex) {
                        ex.printStackTrace();
                    }
                }

            }

        }
    }
}