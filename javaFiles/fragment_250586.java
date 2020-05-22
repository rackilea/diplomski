@Override
public void start(Stage primaryStage) {
    TextArea ta1 = new TextArea();
    ta1.setId("ta1");
    TextArea ta2 = new TextArea();
    ta2.setId("ta2");
    VBox root = new VBox(ta1, ta2);
    root.addEventHandler(FocusEvent.FOCUS_EVENT_TYPE, evt -> {
        System.out.println("focused "+ evt.getTarget());
    });

    ta1.addEventHandler(FocusEvent.FOCUS_EVENT_TYPE, evt -> {
        System.out.println("You focused the first TextArea");
        evt.consume();
    });

    Scene scene = new Scene(root);
    scene.focusOwnerProperty().addListener((o, old, newValue) -> {
        if (newValue != null) {
            FocusEvent event = new FocusEvent(scene, newValue);
            Event.fireEvent(newValue, event);
        }
    });

    primaryStage.setScene(scene);
    primaryStage.show();
}