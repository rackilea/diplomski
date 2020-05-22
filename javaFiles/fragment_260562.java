@Override
    public void start(final Stage stage)
            throws Exception {
        final Pane pane = new Pane();
        final Scene scene = new Scene(pane);
        pane.getChildren().add(blueRect);
        pane.getChildren().add(redRect);

        blueRect.setFill(Color.BLUE);
        redRect.setFill(Color.RED);

        redRect.setBlendMode(BlendMode.ADD);

        redRect.setCache(true);
        redRect.setCacheHint(CacheHint.QUALITY);

        redRect.setClip(new Rectangle(15, 15, 20, 20));

        stage.setScene(scene);
        stage.show();
    }