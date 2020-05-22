public class Main extends Application {

    // Indicates that the divider is currently dragged by the mouse
    private boolean mouseDragOnDivider = false;

    @Override
    public void start(Stage primaryStage) throws Exception{

        SplitPane sp = new SplitPane();

        sp.getItems().addAll(new StackPane(), new StackPane());
        sp.setDividerPositions(0.3f);

        // Listen to the position property
        sp.getDividers().get(0).positionProperty().addListener((obs, oldVal, newVal) -> {
            if(mouseDragOnDivider)
                System.out.println("It's a mouse drag to pos: " + newVal.doubleValue());
        });

        primaryStage.setScene(new Scene(sp, 300, 275));

        sp.requestLayout();
        sp.applyCss();

        // For each divider register a mouse pressed and a released listener
        for(Node node: sp.lookupAll(".split-pane-divider")) {
            node.setOnMousePressed(evMousePressed -> mouseDragOnDivider = true);
            node.setOnMouseReleased(evMouseReleased -> mouseDragOnDivider = false );
        }

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}