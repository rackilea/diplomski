private void clearBorderPane() {
        if ((stage != null) && (stage.getRoot() instanceof BorderPane)) {
             BorderPane pane = (BorderPane)stage.getRoot();
             pane.setTop(null);
        }
    }