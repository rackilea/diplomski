scene.setOnKeyPressed(e -> {
    if(e.getCode() == KeyCode.W && e.isShortcutDown()) {
        System.exit(0);
        // Aside: you should really use Platform.exit() instead of System.exit(0)
        // as it will gracefully shutdown the FX toolkit and ensure your
        // Application's stop() method is called, etc.
    } else if(e.getCode() == KeyCode.M && e.isShortcutDown()) {
        primaryStage.setIconified(true);
    }
});