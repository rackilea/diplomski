double oldx = RBar.getX();
           double oldy = RBar.getY();
           double  moveval = oldacc + averageACC;
           double angle = -30 * Math.PI / 180;
           double newx = oldx - moveval * Math.sin(angle);
           double newy = oldy - moveval * Math.cos(angle);
           double  movex = newx + oldx;
           double movey = newy + oldy;


           Platform.runLater(new Runnable() {
               @Override
               public void run() {
                   final Timeline timeline = new Timeline();
                   timeline.setCycleCount(1);
                   timeline.setAutoReverse(true);
                   final KeyValue targetkvx = new KeyValue(RBar.translateXProperty(), movex);
                   final KeyValue targetkvy = new KeyValue(RBar.translateYProperty(), movey);
                   final KeyFrame kf = new KeyFrame(Duration.millis(100), targetkvx, targetkvy);
                   timeline.getKeyFrames().add(kf);
                   timeline.play();
               }
           });
           oldacc = averageACC;