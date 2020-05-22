public class MyComponent extends VBox {
    private final StringProperty foo = new SimpleStringProperty();

    public MyComponent {
        final Parent root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));

        getChildren().add(root);
    }

    public final StringProperty fooProperty() { return foo; }
    public final String getFoo() { return foo.get(); }
    public final void setFoo(String foo) { this.foo.set(foo); }
}