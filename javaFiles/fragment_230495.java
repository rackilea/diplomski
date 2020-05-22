import javafx.application.Application;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Group;
    import javafx.scene.Scene;
    import javafx.stage.Stage;

    public class SvgIconApp extends Application {

        private final SvgIconViewController controller = new SvgIconViewController();

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage stage) throws Exception {
            FXMLLoader fxmlLoader = new FXMLLoader(SvgIconApp.class.getResource("/svgiconview.fxml"));
            fxmlLoader.setController(controller);
            fxmlLoader.load();
            Scene scene = new Scene(fxmlLoader.getRoot());
            stage.setScene(scene);
            stage.show();
        }
    }

    class SvgIconViewController {

        @FXML
        private Group iconGroup;

        @FXML
        private void onPlusButton(ActionEvent actionEvent) {
            double newScale = iconGroup.getScaleX() + 0.5;
            iconGroup.setScaleX(newScale);
            iconGroup.setScaleY(newScale);
        }

        @FXML
        private void onMinusButton(ActionEvent actionEvent) {
            double newScale = iconGroup.getScaleX() - 0.5;
            iconGroup.setScaleX(newScale);
            iconGroup.setScaleY(newScale);
        }
    }