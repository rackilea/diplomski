import java.awt.Window;

import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;

import org.w3c.dom.Document;


public class WaitingForLogin {

    public WaitingForLogin() throws Exception {
        System.out.println("Showing window...");

        // Run initAndShowUI() on AWT event thread. Block until that is complete:
        SwingUtilities.invokeAndWait(() -> initAndShowUI());

        System.out.println("Now running application");
        for (int i=1; i <=10; i++) {
            System.out.println("Counting: "+i);
            Thread.sleep(500);
        }
    }

    public void initAndShowUI() {
        JDialog dialog = new JDialog((Window)null);
        dialog.setModal(true);
        JFXPanel jfxPanel = new JFXPanel();
        Platform.runLater(() -> initJFX(jfxPanel, dialog));
        dialog.add(jfxPanel);
        dialog.setSize(400, 400);
        dialog.setLocationRelativeTo(null);

        // Since the dialog is modal, this will block execution (of the AWT event thread)
        // until the dialog is closed:
        dialog.setVisible(true);
    }

    private void initJFX(JFXPanel jfxPanel, Window dialog) {

        // Create a web view:
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();

        // Check for a new document being loaded. If the document just contains the 
        // text "Success", then close the dialog (unblocking all threads waiting for it...)
        engine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                Document doc = engine.getDocument();
                if ("Success".equals(doc.getDocumentElement().getTextContent())) {
                    // Close dialog: this must be done on the AWT event thread
                    SwingUtilities.invokeLater(() -> dialog.dispose());
                }
            }
        });

        // Just for testing
        // simulate login with simple button:

        Button button = new Button("Login");
        button.setOnAction(event -> engine.loadContent("Success", "text/plain"));
        HBox controls = new HBox(button);
        controls.setAlignment(Pos.CENTER);
        controls.setPadding(new Insets(10));

        jfxPanel.setScene(new Scene(new BorderPane(webView, null, null, controls, null)));
    }

    public static void main(String[] args) throws Exception {
        new WaitingForLogin();

    }

}