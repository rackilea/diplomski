final Rotate rotate = new Rotate();
rect.getTransforms().add(rotate);

AnimationTimer timer = new AnimationTimer() {
    @Override
    public void handle(long now) {
        stage.getScene().setOnKeyPressed(e -> {
           rotate.setPivotX(rect.getX());
           rotate.setPivotY(rect.getY());
           if (e.getCode() == KeyCode.LEFT) {
               rotate.setAngle(rotate.getAngle() - 5);
           } else if (e.getCode() == KeyCode.RIGHT){
               rotate.setAngle(rotate.getAngle() + 5);
           }
        });
    }
};