private double minX;
private double minY;
private double width;
private double height;
private GraphicsContext gc;
private Image img1;

private void drawImage() {
    gc.drawImage(img1, minX, minY, width, height);
}

private void moveImage() {
    gc.clearRect(minX, minY, width, height);
    minX += 50;
    drawImage();
}

...

    this.gc = canvas.getGraphicsContext2D();
    this.img1 = ...;
    this.minX = 0;
    this.minY = 0;
    this.width = 50;
    this.height = 50;
    this.drawImage();
    theScene.setOnKeyPressed((event) -> {

        if (event.getCode() == KeyCode.RIGHT) {
            moveImage();
        }
    });