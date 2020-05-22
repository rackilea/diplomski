private void setSceneEvents(final Scene scene) {
    //handles mouse scrolling
    scene.setOnScroll(
            new EventHandler<ScrollEvent>() {
              @Override
              public void handle(ScrollEvent event) {
                double zoomFactor = 1.05;
                double deltaY = event.getDeltaY();
                if (deltaY < 0){
                  zoomFactor = 2.0 - zoomFactor;
                }
                System.out.println(zoomFactor);
                page.setScaleX(page.getScaleX() * zoomFactor);
                page.setScaleY(page.getScaleY() * zoomFactor);
                event.consume();
              }
            });

  }