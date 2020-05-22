path.setOnMouseClicked(new EventHandler<MouseEvent>() {

    @Override
    public void handle(MouseEvent t) {
        Path p = (Path)t.getSource()
        p.setStroke(Color.RED);
        p.getStrokeDashArray().clear();
    }
});