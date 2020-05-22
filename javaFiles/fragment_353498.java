public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {

            StackPane root = new StackPane();

            Button button = new Button( "I'm rotating!");

            RotateTransition rotateTransition = createRotateTransition(button);

            button.addEventFilter(MouseEvent.MOUSE_ENTERED, e -> {
                rotateTransition.play();
            });

            button.addEventFilter(MouseEvent.MOUSE_EXITED, e -> {
                rotateTransition.stop();
            });

            root.getChildren().add( button);

            Scene scene = new Scene(root,400,400);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public RotateTransition createRotateTransition(Button button){

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2),button);

        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(720);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(true);

        rotateTransition.statusProperty().addListener(new ChangeListener<Status>() {

            @Override
            public void changed(ObservableValue<? extends Status> observable, Status oldValue, Status newValue) {

                if( newValue == Status.STOPPED) {

                    RotateTransition transition = new RotateTransition(Duration.seconds(2),button);

                    transition.setFromAngle(button.getRotate());
                    transition.setToAngle(0);
                    transition.setCycleCount(1);
                    transition.setAutoReverse(true);
                    transition.play();

                }

            }

        });
        return rotateTransition;
    }


    public static void main(String[] args) {
        launch(args);
    }
}