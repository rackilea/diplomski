package mvpc;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MVPCTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        PresentationModel model = new PresentationModel();
        Presenter presenter = new Presenter();
        MVPCLoader<PresentationModel, Parent, Presenter, Controller> loader = new MVPCLoader<>();
        Scene scene = new Scene(loader.load(getClass().getResource("View.fxml"), model, presenter));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}