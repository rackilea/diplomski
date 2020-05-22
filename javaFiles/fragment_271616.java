package application;

import javafx.application.Preloader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AppPreloader extends Preloader {
    private Stage preloaderStage;
    private Parent root;
    private Scene scene;
    private ProgressIndicator progress_indicator;

    @Override
    public void start(Stage primaryStage) throws Exception {
        progress_indicator = new ProgressIndicator();
        root = new StackPane(progress_indicator);
        scene = new Scene(root, 600, 400);
        this.preloaderStage = primaryStage;
        this.preloaderStage.setScene(this.scene);
        this.preloaderStage.show();
    }


    @Override
    public void handleApplicationNotification(PreloaderNotification pn) {
        if (pn instanceof ProgressNotification) {
           //expect application to send us progress notifications 
           //with progress ranging from 0 to 1.0
           double v = ((ProgressNotification) pn).getProgress();
           progress_indicator.setProgress(v);            
        } else if (pn instanceof StateChangeNotification) {
            StateChangeNotification scn = (StateChangeNotification) pn ;
            if (scn.getType() == StateChangeNotification.Type.BEFORE_START) {
                preloaderStage.hide();
            }
        }
    } 
}