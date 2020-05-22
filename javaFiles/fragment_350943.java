private void moveUp() {
    Line line = new Line(cX, cY, cX, cY - 10);
    line.setStroke(Color.BLUE);
    pane.getChildren().add(line);
    cY -= 10;
}