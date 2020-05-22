@Override
public void start(Stage primaryStage) {
    Canvas canvas = new Canvas(800, 300);

    GraphicsContext gc = canvas.getGraphicsContext2D();
    gc.setFill(Color.RED);
    gc.fillRect(0, 0, 800, 300);

    gc.setStroke(Color.WHITE);

    final double dx = 0;

    for (double x = 10, s = 1; x < (800 - 40); s++, x += 50) {
        gc.setLineWidth(s);
        gc.strokeLine(x + dx, 0, x + dx, 300);
    }

    WritableImage snap = canvas.snapshot(null, null);
    PixelReader reader = snap.getPixelReader();

    for (int x = 10; x < (800 - 40); x += 50) {
        Color color = reader.getColor(x, 150);
        System.out.printf("red=%-3d, green=%-3d, blue=%-3d\n", (int) (color.getRed() * 0xFF),
                (int) (color.getGreen() * 0xFF), (int) (color.getBlue() * 0xFF));
    }

    primaryStage.setScene(new Scene(new StackPane(canvas)));
    primaryStage.show();
}