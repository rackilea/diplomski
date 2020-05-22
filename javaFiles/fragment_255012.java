Scene scene = new Scene(root,600,300);
scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
primaryStage.setScene(scene);
primaryStage.show();

Marquee marqueeLeft = new Marquee(labels, Duration.ZERO, Direction.LEFT, Duration.seconds(10), Interpolator.EASE_BOTH, 10.0);
root.setTop(marqueeLeft);
marqueeLeft.animate();