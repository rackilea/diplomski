primaryStage.fullScreenProperty().addListener((v,o,n) -> {

        if (!primaryStage.isFullScreen()) {

            primaryStage.setResizable(false);
            primaryStage.setResizable(true);
        }
    });