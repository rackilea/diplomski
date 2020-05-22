class Foo {

    private static final String USER_OBJECT_KEY = "USER_OBJECT";

    private final GridPane gridPane = ...;
    private final Button button = ...;

    Foo() {
        ObservableList<Node> mirror = FXCollections.observableArrayList(
                n -> new Observable[]{n.getProperties()}
        );
        Bindings.bindContent(mirror, gridPane.getChildren());
        FilteredList<Node> filtered = mirror.filtered(
                n -> !n.getProperties().containsKey(USER_OBJECT_KEY)
        );
        button.disableProperty(Bindings.isEmpty(filtered));
    }

}