public class MainApp extends Application {

    private int c;

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        final Line l1 = new Line(200,80,200,0);

        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");

                Platform.runLater(new Runnable() {
                    Random rn = new Random();
                    @Override

                    public void run() {
                        if(c==0)
                        {
                            System.out.println("c=" + c);
                            l1.setStartX(rn.nextInt(400));
                            l1.setStartY(rn.nextInt(400));
                            c = 1;
                        }
                        else
                        {
                            System.out.println("c=" + c);
                            l1.setEndX(rn.nextInt(400));
                            l1.setEndY(rn.nextInt(400));
                            c = 0;
                        }
                    }
                });
            }
        });


        l1.setStroke(Color.YELLOW);
        l1.setStrokeWidth(2);

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(l1);

        Scene scene = new Scene(root, 400, 400, Color.WHITE);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}