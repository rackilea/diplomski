private void transitionTextureToActor(ShapeProcessor shapeProcessor, Image iconClicked) {
    tempActor = shapeProcessor.getAnimatedImage();
    tempActor.setSize(shapeProcessor.getWidth(), shapeProcessor.getHeight());
    tempActor.setPosition(shapeProcessor.getX(), shapeProcessor.getY());
    tempActor.setVisible(true);
    shapeProcessor.setVisible(false);

    final Actor localReference = tempActor;

    tempActor.addAction(
            sequence(
                    parallel(
                            sizeTo(iconClicked.getDrawable().getMinWidth(), iconClicked.getDrawable().getMinHeight(), .3F),
                            moveTo(iconClicked.getX(), iconClicked.getY(), .3f)
                    ),
                    run(new Runnable() {
                        @Override
                        public void run() {
                            localReference.setVisible(false);
                        }
                    })
            )
    );
}