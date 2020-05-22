public class Main extends Application {

    private static Group root = new Group();
    private static Scene initialScene = new Scene(root, Color.BLACK);

    private static final int NUM_OF_CLIENTS = 8;

    private static long updateSpeed = 20_666_666L;
    private static double deltaTime;
    private static double counter = 0;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setFullScreen(true);
        primaryStage.setScene(initialScene);
        primaryStage.show();

        initModel();
        initModelViews();
        startUpdates();
    }

    private void initModel() {
        for (int i = 0; i < NUM_OF_CLIENTS; i++) {
            Model.add(new UpdateObject());
        }
    }

    private void initModelViews() {
        //Correctly positioning the views
        int xPanes = (NUM_OF_CLIENTS / 4.0 > 1.0) ? 4 : NUM_OF_CLIENTS;
        int yPanes = (NUM_OF_CLIENTS / 4) + ((NUM_OF_CLIENTS % 4 > 0) ? 1 : 0);

        for (int i = 0; i < NUM_OF_CLIENTS; i++) {
            Pane clientView = new Pane(copyModelNodes());
            clientView.setBackground(new Background(new BackgroundFill(Color.color(Math.random(), Math.random(), Math.random()), CornerRadii.EMPTY, Insets.EMPTY)));
            System.out.println(clientView.getChildren());
            clientView.relocate((i % 4) * (Main.initialScene.getWidth() / xPanes), (i / 4) * (Main.initialScene.getHeight() / yPanes)) ;
            clientView.setPrefSize((Main.initialScene.getWidth() / xPanes), (Main.initialScene.getHeight() / yPanes));
            root.getChildren().add(clientView);
        }
    }

    private Node[] copyModelNodes() {
        ObservableList<UpdateObject> model = Model.getModel();
        Node[] modelCopy = new Node[model.size()];

        for (int i = 0; i < model.size(); i++) {
            ImageView testNode = new ImageView();
            testNode.setImage(model.get(i).getImage());
            testNode.layoutXProperty().bind(model.get(i).layoutXProperty());
            testNode.layoutYProperty().bind(model.get(i).layoutYProperty());
            testNode.rotateProperty().bind(model.get(i).rotateProperty());
            modelCopy[i] = testNode;
        }
        return modelCopy;
    }

    private void startUpdates() {
        AnimationTimer mainLoop = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long frameTime) {

                //Time difference from last frame
                deltaTime = 0.00000001 * (frameTime - lastUpdate);

                if (deltaTime <= 0.1 || deltaTime >= 1.0)
                    deltaTime = 0.00000001 * updateSpeed;

                if (frameTime - lastUpdate >= updateSpeed) {
                    update();
                    lastUpdate = frameTime;
                }
            }
        };
        mainLoop.start();
    }

    private void update() {
        counter += 0.1;

        if (counter > 10.0) {
            counter = 0;
        }
        for (UpdateObject objectToUpdate : Model.getModel()) {
            objectToUpdate.setLayoutX(objectToUpdate.getLayoutX() + 0.02 * counter * deltaTime);
            objectToUpdate.setLayoutY(objectToUpdate.getLayoutY() + 0.02 * counter * deltaTime);
            objectToUpdate.setRotate(objectToUpdate.getRotate() + 5);
        }
    }
}