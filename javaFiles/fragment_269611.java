import io.vertx.reactivex.core.Vertx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXRunner extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button btn = new Button("Start server");
        btn.setOnAction(event -> {
            Vertx.vertx().createHttpServer()
                    .requestHandler(req -> req.response().end("Bingo :D"))
                    .listen(8080);
            btn.setDisable(true);
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 300, 250);
        stage.setTitle("Vert.x Server");
        stage.setScene(scene);
        stage.show();
    }
}