Task<Point2D> task = new Task<Point2D>() {

    @Override
    protected Point2D call() throws Exception {
        while (!isCancelled()) {
            Point2D eyePos = getEyePos();
            updateValue(eyePos);
        }
    }

};

AnimationTimer animation = new AnimationTimer() {

    @Override
    public void handle(long now) {
        Point2D point = task.getValue();
        if (value != null) {
            Point2D pointOnScreen = node.screenToLocal(point);

            // TODO: use result
        }
    }

};
animation.play();