root.getChildren().addAll(line(32), line(48), line(64));
…
private SVGPath line(int size) {
    SVGPath path = new SVGPath();
    path.setStroke(Color.BLUE);
    path.setContent("M0,0L" + size + "," + size + "z");
    return path;
}