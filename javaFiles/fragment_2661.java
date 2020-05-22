public Image combine(double offsetX, double offsetY, double sizeX, double sizeY, List<? extends Image> images) {
    double width = (images.size()-1) * offsetX + sizeX;
    double height = (images.size()-1) * offsetY + sizeY;

    canvas.setWidth(width);
    canvas.setHeight(height);
    gc.clearRect(0, 0, width, height);
    gc.setFill(Color.WHITE);

    for (int i = 0, size = images.size(); i < size; i++) {
        double x = i * offsetX;
        double y = i * offsetY;
        gc.fillRect(x, y, sizeX, sizeY);
        Image img = images.get(i);

        gc.drawImage(img, x, y, sizeX, sizeY);
    }

    return canvas.snapshot(PARAMETERS, null);
}

private Canvas canvas;
private GraphicsContext gc;
private static final SnapshotParameters PARAMETERS = new SnapshotParameters();

static {
    PARAMETERS.setFill(Color.TRANSPARENT);
}

private void initCanvas() {
    canvas = new Canvas();
    gc = canvas.getGraphicsContext2D();
    gc.setFill(Color.WHITE);
}


@Override
public void start(Stage primaryStage) {
    initCanvas();

    Button btn = new Button("Drag Source");
    Image img1 = new Image("http://cdn.sstatic.net/Sites/stackoverflow/company/img/logos/se/se-icon.png?v=93426798a1d4", 100, 100, true, true);
    Image img2 = new Image("http://cdn.sstatic.net/Sites/stackoverflow/company/img/logos/sf/sf-icon.png?v=6c3100d858bb", 100, 100, true, true);
    Image img3 = new Image("http://cdn.sstatic.net/Sites/stackoverflow/company/img/logos/so/so-icon.png?v=c78bd457575a", 100, 100, true, true);

    DataFormat format = new DataFormat("application/custom");

    btn.setOnDragDetected(evt -> {
        Dragboard db = btn.startDragAndDrop(TransferMode.COPY);

        db.setDragView(combine(25, 25, img1.getWidth(), img1.getHeight(), Arrays.asList(img1, img2, img3)));

        ClipboardContent content = new ClipboardContent();
        content.put(format, "something");
        db.setContent(content);

        evt.consume();
    });
    ...