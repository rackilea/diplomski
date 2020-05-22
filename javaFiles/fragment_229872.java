public class MyComponent extends VBox {
    // Other stuff

    private MyController controller;

    public MyComponent {
        // Original stuff

        this.controller = loader.getController();
    }

    public final StringProperty fooProperty() {
        assert controller != null; // If you loaded correctly this assertion should be valid

        return controller.fooProperty();
    }

    public final String getFoo() { return fooProperty().get(); }
    public final void setFoo(String foo) { fooProperty().set(foo); }
}