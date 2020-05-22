public class TextCanvas extends Application {

    private GraphicsContext gc;

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        Canvas canvas = createCanvas();

        ToggleButton draw = new ToggleButton("Draw");
        ToggleButton erase = new ToggleButton("Erase");
        ToggleGroup drawErase = new ToggleGroup();
        draw.setToggleGroup(drawErase);
        erase.setToggleGroup(drawErase);
        drawErase.selectedToggleProperty().addListener((ov, oldV, newV) -> {
            if (newV == null) {
                gc.setStroke(Color.TRANSPARENT);
                canvas.setMouseTransparent(true);
            } else if (drawErase.getSelectedToggle().equals(draw)) {
                System.out.println("Fd");
                gc.setStroke(Color.BLACK);
                canvas.setMouseTransparent(false);
            } else if (drawErase.getSelectedToggle().equals(erase)) {
                gc.setStroke(Color.WHITE);
                canvas.setMouseTransparent(false);
            }
        });

        Button clear = new Button("Clear");
        clear.setOnAction(e -> gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()));

        CheckBox cb = new CheckBox("Show canvas");
        cb.setSelected(true);
        canvas.visibleProperty().bind(cb.selectedProperty());

        VBox buttonBox = new VBox(draw, erase, clear, cb);

        StackPane stack = new StackPane(textArea, canvas);
        ScrollPane scrollPane = new ScrollPane(stack);
        scrollPane.setFitToHeight(true);

        canvas.widthProperty().bind(scrollPane.widthProperty());
        canvas.heightProperty().bind(scrollPane.heightProperty());

        stack.setBackground(new Background(new BackgroundFill(Color.STEELBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        BorderPane border = new BorderPane();
        border.setCenter(scrollPane);
        border.setBottom(buttonBox);

        primaryStage.setMaximized(true);
        primaryStage.setTitle("Practice Canvas");
        primaryStage.setScene(new Scene(border));
        primaryStage.show();
    }

    private Canvas createCanvas() {
        Canvas canvas = new Canvas();
        gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(3);

        canvas.setOnMouseEntered(event -> canvas.setCursor(Cursor.CROSSHAIR));
        canvas.setOnMouseExited(event -> canvas.setCursor(Cursor.DEFAULT));

        canvas.setOnMousePressed(event -> {
            gc.beginPath();
            gc.lineTo(event.getX(), event.getY());
            gc.moveTo(event.getX(), event.getY());
            gc.stroke();
        });
        canvas.setOnMouseDragged(event -> {
            gc.lineTo(event.getX(), event.getY());
            gc.stroke();
        });

        canvas.setMouseTransparent(true);
        return canvas;
    }

    public static void main(String[] args) {
        launch(args);
    }
}