import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SwingBrowser extends JPanel {

    WebEngine webEngine;

    private static void initAndShowGUI() {

        JFrame frame = new JFrame();

        frame.add(new SwingBrowser());
        frame.setSize(1024, 768);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public SwingBrowser() {

        JPanel toolbar = new JPanel();
        toolbar.setLayout(new FlowLayout());

        JButton button;

        button = new JButton("Google");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                loadPage("http://www.google.com");
            }
        });

        toolbar.add(button);

        button = new JButton("NY Times");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                loadPage("http://www.nytimes.com");
            }
        });

        toolbar.add(button);

        final JFXPanel fxPanel = new JFXPanel();

        setLayout(new BorderLayout());
        add(fxPanel, BorderLayout.CENTER);
        add(toolbar, BorderLayout.NORTH);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
        });
    }

    private void loadPage(String url) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                webEngine.load(url);

            }
        });

    }

    private void initFX(JFXPanel fxPanel) {
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    private Scene createScene() {

        WebView webView = new WebView();

        webEngine = webView.getEngine();

        webEngine.getLoadWorker().progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                System.out.println("Process changed: " + arg0 + ", arg1: " + arg1 + ", arg2: " + arg2);
            }
        });

        webEngine.getLoadWorker().messageProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                System.out.println("message changed: " + arg0 + ", arg1: " + arg1 + ", arg2: " + arg2);
            }
        });

        webEngine.getLoadWorker().exceptionProperty().addListener(new ChangeListener<Throwable>() {
            @Override
            public void changed(ObservableValue<? extends Throwable> arg0, Throwable arg1, Throwable arg2) {
                System.out.println(arg0);
                System.out.println(arg1);
                System.out.println(arg2);
            }
        });

        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> arg0, Worker.State arg1, Worker.State arg2) {
                System.out.println("old state: " + arg1 + ", new state: " + arg2 + ", arg0: " + arg0);
            }
        });

        webEngine.load("http://www.google.com");

        BorderPane bp = new BorderPane();

        bp.setCenter(webView);

        Scene scene = new Scene(bp);

        return (scene);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initAndShowGUI();
            }
        });
    }
}