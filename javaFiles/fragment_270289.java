DoubleBinding width = Bindings.createDoubleBinding(
    () -> source.getLayoutBounds().getWidth(), 
    source.layoutBoundsProperty());

line.startXProperty().bind(
    source.layoutXProperty().add(
        Bindings.createDoubleBinding(width.divide(2)));

DoubleBinding height = Bindings.createDoubleBinding(
    () -> source.getLayoutBounds().getHeight(), 
    source.layoutBoundsProperty());

line.startYProperty().bind(
    source.layoutYProperty().add(
        Bindings.createDoubleBinding(height.divide(2)));