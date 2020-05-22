import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.embed.swing.SwingNode;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

public class JunkFx extends Application {
    public void openDialog(MouseEvent event) {
        JFileChooser fileChooser = new JFileChooser("why");
        SwingNode swingNode = new SwingNode();

        SwingUtilities.invokeLater(() -> {
            swingNode.setContent(fileChooser);
        });

        BorderPane pane = new BorderPane();
        pane.setCenter(swingNode);

        Stage stage = new Stage();

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();

        fileChooser.addActionListener(evt->{
            System.out.println(evt.getActionCommand());
            System.out.println(fileChooser.getSelectedFile());
            Platform.runLater(stage::hide);
        });

    }


    @Override
    public void start(Stage stage) throws Exception {
        Button b = new Button("click");
        b.setOnMouseClicked(this::openDialog);
        Scene scene = new Scene(new StackPane(b), 640, 480);
        stage.setTitle("open a dialog");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args){
        launch(args);
    }
}