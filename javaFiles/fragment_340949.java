package application;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Main extends Application {

    private TextArea textArea;
    public SimpleStringProperty valueProperty = new SimpleStringProperty();
    private Service<Void> service;

    private void before(){
        valueProperty.set("Start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        valueProperty.set("Credentials are OK");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }

        private void process(){
            valueProperty.set("In process..");
            try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            valueProperty.set("...");
        }

        private void after(){
        //similar body
        }

        public void install(){
            before();
            process();
            after();
            }

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();
        Scene scene = new Scene(root, 450, 250, Color.WHITE);

        textArea = new TextArea();

        service = new Service<Void>() {

            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {

                        Main.this.valueProperty.addListener(new ChangeListener<String>() {
                            @Override
                            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                    String newValue) {
                                updateMessage(newValue);
                            }
                        });
                        Main.this.install();


                        return null;
                    }
                };
            }

        };
        textArea.textProperty().bind(service.messageProperty());

        service.setOnSucceeded(event -> {
            System.out.println("Done!");
            textArea.textProperty().unbind();
        });

        service.start();

        VBox vbox = new VBox();
        vbox.getChildren().addAll(textArea);
        vbox.fillWidthProperty().set(true);
        root.getChildren().add(vbox);



        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}