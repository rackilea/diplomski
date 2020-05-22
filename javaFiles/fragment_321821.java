FlowPane flow = new FlowPane();

    ListView<Node> wrappedNodeView = new ListView<>();

    ChangeListener<Bounds> boundsListener = (obs, oldBounds, newBounds) -> 
        wrappedNodeView.getItems().setAll(findWrapped(flow));

    flow.getChildren().addListener((Change<? extends Node> c) -> {
        while (c.next()) {
            if (c.wasAdded()) {
                c.getAddedSubList().forEach(node -> node.boundsInParentProperty().addListener(boundsListener));
            }
            if (c.wasRemoved()) {
                c.getRemoved().forEach(node -> node.boundsInParentProperty().removeListener(boundsListener));
            }
        }
        wrappedNodeView.getItems().setAll(findWrapped(flow));           
    });