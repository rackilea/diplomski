final Path path = new Path();

//...

path.setOnMouseClicked(new EventHandler<MouseEvent>() {

    @Override
    public void handle(MouseEvent t) {
        path.setStroke(Color.RED);
        path.getStrokeDashArray().clear();
    }
});