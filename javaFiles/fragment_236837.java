final Text text = new Text("Click me");
text.setFont(Font.font("DejaVu Sans Mono", 42));

text.setOnMouseClicked(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
        // set with long text
        text.setText("Hello Sun, Hello Galaxy, Hello Space!");
    }
});

text.layoutBoundsProperty().addListener(new ChangeListener<Bounds>() {
    @Override
    public void changed(ObservableValue<? extends Bounds> observable, Bounds oldValue, Bounds newValue) {
        if(oldValue.getHeight() != newValue.getHeight() || oldValue.getWidth()!= newValue.getWidth()) {
            roundedRectangle.setWidth(newValue.getWidth() + 100);
            roundedRectangle.setHeight(newValue.getHeight() + 30);
        }
    }
});