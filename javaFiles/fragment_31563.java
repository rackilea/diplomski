@Override
public void start(Stage stage) throws Exception {
    Flow flow = new Flow(ManageCtrl.class);

    // create a handler to initialize a view and a sceneRoot.
    FlowHandler handler = flow.createHandler();
    StackPane sceneRoot = handler.start();

    // retrieve the injected controller from the view.
    FlowView view = handler.getCurrentView();
    controller = (ManageCtrl) view.getViewContext().getController();

    // attach the sceneRoot to stage.
    stage.setScene(new Scene(sceneRoot));
    stage.show();
}