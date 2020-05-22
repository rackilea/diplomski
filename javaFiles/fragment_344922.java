import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * @see https://stackoverflow.com/a/44091479/230513
 * @see https://stackoverflow.com/a/31576647/230513
 */
public class WebViewTest {

    private void initAndShowGUI() {
        // This method is invoked on the EDT thread
        JFrame frame = new JFrame("WebViewTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane jtp = new JTabbedPane();
        jtp.add("One", createTab("http://www.example.com"));
        jtp.add("Two", createTab("http://www.example.net"));
        jtp.add("Three", createTab("http://www.example.org"));
        frame.add(jtp, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JFXPanel createTab(String s) {
        final JFXPanel fxPanel = new JFXPanel() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(640, 480);
            }
        };
        Platform.runLater(() -> {
            initFX(fxPanel, s);
        });
        return fxPanel;
    }

    private void initFX(JFXPanel fxPanel, String s) {
        // This method is invoked on the JavaFX thread
        StackPane root = new StackPane();
        Scene scene = new Scene(root);
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load(s);
        root.getChildren().add(webView);
        fxPanel.setScene(scene);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new WebViewTest()::initAndShowGUI);
    }
}