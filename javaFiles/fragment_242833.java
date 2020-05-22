ChangeListener<Number> xListener = (obs, oldX, newX) -> 
    line.setEndX(newX.doubleValue());
pointedToNode.addListener((obs, oldNode, newNode) -> {
    if (oldNode != null) {
        oldNode.layoutXProperty().removeListener(xListener);
    }
    if (newNode != null) {
        newNode.layoutXProperty().addListener(listener);
    }
});