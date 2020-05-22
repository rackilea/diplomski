package madoc.controllers.components;

...

public class LabelController extends VBox {

    public LabelController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/madoc/controllers/components/Label.fxml")); // TODO: replace with correct resoure path?
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch(IOException ex) {
            throw new IllegalStateException("Could not load fxml file", ex);
        }
    }

    @FXML
    public Label label;

    // Define a variable to store the property
    private final DoubleProperty amountDue = new SimpleDoubleProperty();

    // Define a getter for the property's value
    public final double getAmountDue(){return amountDue.get();}

    // Define a setter for the property's value
    public final void setAmountDue(double value){amountDue.set(value);}

    // Define a getter for the property itself
    public DoubleProperty amountDueProperty() {return amountDue;}

    ...
}