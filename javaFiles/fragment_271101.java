import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application {

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        VBox mainContent = new VBox();
        Scene scene = new Scene(root);

        ProgressBar loadingOverlay = new ProgressBar();

        root.getChildren().add(loadingOverlay);

        stage.setTitle("Gallery");
        stage.setScene(scene);

        Query query = new Query();
        query.progressProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            Platform.runLater(() -> {
                loadingOverlay.setProgress(newValue.doubleValue());
            });
        });

        Runnable r = () -> {
            try {
                query.parseQuery("rock", 50);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            Platform.runLater(() -> {
                System.out.println("Done");
                root.getChildren().remove(loadingOverlay);
                root.getChildren().add(new Button("All done here"));
                stage.sizeToScene();
            });
        };
        new Thread(r).start();

        stage.show();
    }

    public class Query {

        private ReadOnlyDoubleWrapper progressProperty;

        public Query() {
            progressProperty = new ReadOnlyDoubleWrapper(this, "progress");
        }

        public ReadOnlyDoubleProperty progressProperty() {
            return progressProperty;
        }

        void parseQuery(String query, int numberOf) throws IOException {
            query = "https://itunes.apple.com/search?limit=" + numberOf + "&term=" + URLEncoder.encode(query);

            URL url = new URL(query);

            progressProperty.set(0.0);

            try (InputStreamReader reader = new InputStreamReader(url.openStream())) {
                for (int index = 0; index <= numberOf; index++) {
                    double progress = index / (double) numberOf;
                    progressProperty.set(progress);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                    }
                }
            }
//      JsonParser jp = new JsonParser();

//      return jp.parse(reader);
        }

//  static String[] generateURLS(String query,^ int numberOf) {
//      String[] URLS = new String[numberOf];
//      try {
//          JsonElement json = parseQuery(query, numberOf);
//
//          JsonObject root = json.getAsJsonObject();                      // root of response
//          JsonArray results = root.getAsJsonArray("results");          // "results" array
//          int numResults = results.size();                             // "results" array size
//          for (int i = 0; i < numResults; i++) {
//              JsonObject result = results.get(i).getAsJsonObject();    // object i in array
//              JsonElement artworkUrl100 = result.get("artworkUrl100"); // artworkUrl100 member
//              if (artworkUrl100 != null) {                             // member might not exist
//                  String artUrl = artworkUrl100.getAsString();        // get member as string
//                  URLS[i] = artUrl;                       // print the string
//              } // if
//          } // for
//      } catch (IOException e1) {
//          // TODO Auto-generated catch block
//          e1.printStackTrace();
//      }
//      return URLS;
//  }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}