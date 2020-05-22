public class SucheController {

    private final ObjectProperty<Foo> foo = new SimpleObjectProperty<>();

    public ObjectProperty<Foo> fooProperty() {
        return foo() ;
    }

    public final Foo getFoo() {
        return fooProperty().get();
    }

    public final void setFoo(Foo foo) {
        fooProperty().set(foo);
    }

    // ...

    @FXML
    private void someHandlerMethod() {

        // FXMLLoader loader = new FXMLLoader(getClass().getResource("Menge.fxml"));
        // try {
        //     Parent root = loader.load();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        // MengeController controller = (MengeController)loader.getController();

        setFoo(...);
    }
}