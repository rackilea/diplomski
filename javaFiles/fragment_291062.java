import java.awt.BorderLayout;
import java.awt.Dimension;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class JavaFX_And_Swing extends JApplet {

    private final int WIDTH = 300;
    private final int HEIGHT = 250;
    private static JFXPanel fxContainer;
    private static JFXPanel fxContainerTwo;
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                }
                JFrame frame = new JFrame("JavaFX embeded in Swing");
                frame.setLayout(new BorderLayout(5, 5));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JApplet applet = new JavaFX_And_Swing();
                applet.init();
                frame.setContentPane(applet.getContentPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                applet.start();
            }
        });
    }

    @Override
    public void init() {
        fxContainer = new JFXPanel();
        fxContainer.setPreferredSize(new Dimension(WIDTH / 5, HEIGHT / 5));
        add(fxContainer, BorderLayout.NORTH);
        fxContainerTwo = new JFXPanel();
        fxContainerTwo.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(fxContainerTwo, BorderLayout.CENTER);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                createScene();
                createScene2();
            }
        });
    }

    private void createScene() {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root, Color.BLUEVIOLET);
        fxContainer.setScene(scene);
    }

    private void createScene2() {
        Button btn = new Button();
        btn.setText("Say 'Hello World' Two");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root, Color.ALICEBLUE);
        fxContainerTwo.setScene(scene);
    }
}