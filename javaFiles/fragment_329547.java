public class Main extends Application {

    private Label xLabel;
    private Label yLabel;

    @Override
    public void start(Stage primaryStage) {
        xLabel = new Label("X Coordinate: 0");
        yLabel = new Label("y Coordinate: 0");

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(xLabel, yLabel);

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.show();

        updateCoordintates();
    }

    private void updateCoordintates(){
        new Thread(()->{ //Splits off the Main thread
            double lastX = 1;
            double lastY = 1;
            while (true) { //Will run forever you may want to change this not sure of your constraints
                double x = MouseInfo.getPointerInfo().getLocation().getX();
                double y = MouseInfo.getPointerInfo().getLocation().getY();

                //The platform.runlater will allow you to post the change to the screen when available
                if(x!=lastX)
                    Platform.runLater(()->xLabel.setText(String.valueOf(x)));
                if(y!=lastY)
                    Platform.runLater(()->yLabel.setText(String.valueOf(y)));

                lastX = x;
                lastY = y;
                System.out.println("X = " + x + "\tY = " + y);
            }
        }).start();
    }
    public static void main(String[] args) { launch(args); }
}