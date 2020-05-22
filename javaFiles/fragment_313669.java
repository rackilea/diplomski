newConnDialog.setOnShown(new EventHandler<WindowEvent>() {
    @Override
    public void handle(WindowEvent t) {
        tabPane.getTabs().remove(tab);
    }
});