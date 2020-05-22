BorderPane border = new BorderPane();
IntegerProperty intProp = new SimpleIntegerProperty();

border.leftProperty().bind(Bindings.createObjectProperty(
    () -> {
        int value = intProp.get();
        Node node = getLeftNodeForValue(value);
        return node ;
    },
    intProp));