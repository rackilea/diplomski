import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Test extends Application {

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root);

        ProgressBar loadingOverlay = new ProgressBar();

        root.getChildren().add(loadingOverlay);

        stage.setTitle("Gallery");
        stage.setScene(scene);

        Query query = new Query("", 50);
        loadingOverlay.progressProperty().bind(query.progressProperty());
        query.setOnSucceeded((event) -> {
                System.out.println("Done");
                root.getChildren().remove(loadingOverlay);
                root.getChildren().add(new Button("All done here"));
                stage.sizeToScene();
        });
        new Thread(query).start();

        stage.show();
    }

    public class Query extends Task<URL[]> {

        private String query;
        private int count;

        public Query(String query, int count) {
            this.query = query;
            this.count = count;
        }

        @Override
        protected URL[] call() throws Exception {
            query = "https://itunes.apple.com/search?limit=" + count + "&term=" + URLEncoder.encode(query);

            URL url = new URL(query);

            try (InputStreamReader reader = new InputStreamReader(url.openStream())) {
                for (int index = 0; index <= count; index++) {
                    updateProgress(index, count);
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException ex) {
                    }
                }
            }

            return new URL[0];
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}