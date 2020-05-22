import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Model {

    private final BooleanProperty red = new SimpleBooleanProperty();

    public final BooleanProperty redProperty() {
        return this.red;
    }


    public final boolean isRed() {
        return this.redProperty().get();
    }


    public final void setRed(final boolean red) {
        this.redProperty().set(red);
    }


    public void toggleRed() {
        setRed(! isRed() );
    }
}